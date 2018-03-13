import pygame
class PhysicsObject:
    pos =[0,0]
    vel=[0,0]
    boundingBox=[0,0]
    halfBox=[0,0]
    color=(0,255,0)
    def __init__(self,pos,vel,boundingBox):
        self.pos=pos
        self.vel=vel
        self.boundingBox=boundingBox
        self.halfBox=boundingBox*.5
    
    def update(self,dt):
        pos+=vel*dt
        
    def draw(self,display):
        pygame.draw.rect(display,self.color,(x,y,width,height))
    def drawBounding(self,display):
        pygame.draw.rect(display,self.color,self.pos-self.halfBox+self.boundingBox,2)
        
        
