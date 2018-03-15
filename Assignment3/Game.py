from Objects import *
from GameState import MenuState
from Constants import *
import pygame
print("Hello world");
class FlappyBird:
    def __init__(self):
        pygame.init()
        
        self.screen = pygame.display.set_mode((Width,Height))
        self.clock = pygame.time.Clock()
        self.sheet = pygame.image.load("sprites.png");
        self.state=MenuState(self)
        self.nextState=self.state
        
        
    def play(self):
        while True:
            events=pygame.event.get()
            for event in events:
                if event.type == pygame.QUIT:
                    pygame.quit() 
                    exit()
            self.state.useInput(events)
            self.state.update(self.clock.get_time()/1000.0);
            self.state.draw(self.screen)
            self.clock.tick(60)
            pygame.display.flip()
            self.state=self.nextState
        

game=FlappyBird()
game.play()

