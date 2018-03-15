import pygame

class MouseEvent:
    def __init__(self, x, y):
        self.consumed=False
        self.x=x
        self.y=y
class Button:
    def __init__(self, sheet, x, y, location):
        self.listeners=[]
        location = pygame.Rect(location)
        self.sheet=sheet
        self.x=x
        self.y=y
        self.width=location.width*3
        self.height=location.height*3
        self.image=pygame.Surface(location.size).convert()
        self.image.blit(sheet, (0, 0), location)
        self.image=pygame.transform.scale(self.image, (self.width, self.height))
    def draw(self, screen, x, y):
        screen.blit(self.image,(x+self.x, y+self.y))
    def addListener(self,  listener):
        self.listeners.append(listener)
    def click(self,  x, y):
        x-=self.x
        y-=self.y
        return x>0 and y>0 and x<self.width  and y<self.height
    
    
    
