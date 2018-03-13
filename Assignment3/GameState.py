import pygame
import random
from Constants import *
from Objects import Bird,Wall
class PlayState:
    def __init__(self,game):
        self.game=game
        self.b=Bird(game.sheet, BirdStartX,BirdStartY,0,0)
        self.walls=[];
        self.diedAt=0
        for i in range(0,WallCount):
            self.walls.append(Wall(game.sheet, FirstWall+WallDistance*i,random.randint(WallGap,Height)))
        self.lastwall=WallCount*WallDistance-WallWidth

    def useInput(self,events):
        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                self.b.flap()
            elif event.type == pygame.KEYUP and event.key == pygame.K_SPACE:
                self.b.stop()

    def update(self, delta):
        if(self.diedAt==0):
            self.b.update(delta)
            if(self.b.y>Height):
                self.diedAt=pygame.time.get_ticks()
            for wall in self.walls:
                wall.update(delta)
                if(self.b.collides(wall)):
                    self.diedAt=pygame.time.get_ticks()
                if(wall.x<-WallWidth):
                    self.lastwall+=WallDistanceIncrease
                    wall.x=self.lastwall
                    wall.y=random.randint(WallGap,Height)
        elif(self.diedAt+1000<pygame.time.get_ticks()):
             self.game.nextState=MenuState(self.game)

    def draw(self,screen):
        screen.fill((0, 0, 0))
        self.b.draw(screen)
        for wall in self.walls:
            wall.draw(screen)
    
class DeadState:
    pass
class MenuState:
    def __init__(self,game):
        self.game=game
    def useInput(self,events):
        for event in events:
            if event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                self.game.nextState=PlayState(self.game)
    def update(self, delta):
        pass
    def draw(self,screen):
        screen.fill((0, 0, 0))
