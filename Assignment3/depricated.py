from Objects import Bird,Wall
import pygame
import random

pygame.init()
screen = pygame.display.set_mode((800, 600))
clock = pygame.time.Clock()
quit=False
while not quit:
    b=Bird(100,0,0,0)
    walls=[];
    for i in range(0,5):
        walls.append(Wall(800+400*i,random.randint(Wall.gap,600)))
    ended=False
    lastwall=5*400-80
    while not ended:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                quit =ended= True
            elif event.type == pygame.KEYDOWN and event.key == pygame.K_SPACE:
                b.flap()
        b.update()
        if(b.y>600):
            ended=True
        screen.fill((0, 0, 0))
        for wall in walls:
            wall.update();
            wall.drawCollision(screen)
            if(b.collides(wall)):
                ended=True
            if(wall.x<-Wall.width):
                lastwall+=10
                wall.x=lastwall
                wall.y=random.randint(Wall.gap,600)
        b.drawCollision(screen)
        pygame.display.flip()
        clock.tick(60)
