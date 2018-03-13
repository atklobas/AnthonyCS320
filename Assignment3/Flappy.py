import pygame
from Objects import PhysicsObject
pygame.init()
disp=pygame.display.set_mode((800,800))
pygame.display.set_caption("mai gaem")
clock=pygame.time.Clock()

width=1000;
height=1000;
gravity=10;



def drawRect(x,y,width,height):
    pygame.draw.rect(disp,(255,0,0),(x,y,width,height),2)

def recursiveRect(x,y,width,height):
    if(width<50):
        return
    drawRect(x,y,width,height)
    delta=(width)*.1
    recursiveRect(x+delta/2,y+delta/2,width-delta,height-delta)

bird= PhysicsObject([100,100],[0,0],[100,100])
crashed=False;
while not crashed:
    for event in pygame.event.get():
        if (event.type == pygame.QUIT):
            crashed=True
        else :""
            #disp.fill((0,0,0))
            #recursiveRect(pygame.mouse.get_pos()[0]-width/2,pygame.mouse.get_pos()[1]-height/2,width,height)
        #print (event)
    pygame.display.update()
    bird.drawBounding(disp)
    bird.draw
    dt=clock.tick(60)/1000.

pygame.quit()
#quit() 
