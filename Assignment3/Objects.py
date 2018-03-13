import pygame
from Constants import *
import math
import copy
class AnimatedSprite():
    def __init__(self, sheet, rect,  x, y,  offsetX, offsetY, rotation, scale):
        self.x=x
        self.y=y
        self.offsetX=offsetX
        self.offsetY=offsetY
        self.rotation=rotation
        self.scale=scale
        rect = pygame.Rect(rect)
        self.original=pygame.Surface(rect.size).convert()
        self.original.blit(sheet, (0, 0), rect)
        self.rendered=pygame.transform.rotozoom(self.original, rotation, scale)
    def update(self):
        pass
    def rotate(self, rotation):
        self.rotation=rotation
        self.rendered=pygame.transform.rotozoom(self.original, self.rotation, self.scale)
    def draw(self, screen,group):
        rect = self.rendered.get_rect()
        screen.blit(self.rendered,(group.x+self.x-self.offsetX*self.scale-rect.width/2, group.y+self.y-self.offsetY*self.scale-rect.height/2))
        #(group.x+self.x-self.offsetX*self.scale, group.y+self.y-self.offsetY*self.scale)
class Drawable:
    def __init__(self):
        self.sprites=[];
    def draw(self, screen):
        for sprite in self.sprites:
            sprite.draw(screen,  self)
        if DrawCollisions and isinstance(self, Collidable):
            self.drawCollision(screen)

class Rectangle:
    def __init__(self,x,y,width,height):
        self.x=x
        self.y=y
        self.width=width
        self.height=height
        self.debugColor=(255,0,0)
    def collides(self,group,o,ogroup):
        relx=group.x-ogroup.x+self.x-o.x;
        rely=group.y-ogroup.y+self.y-o.y;
        relx=abs(relx)
        rely=abs(rely)
        return (relx<(self.width+o.width)/2 and rely<(self.height+o.height)/2)
    def drawCollision(self,group, screen):
        pygame.draw.rect(screen, self.debugColor, pygame.Rect(self.x+group.x-self.width/2, self.y+group.y-self.height/2, self.width, self.height),2)

class Circle:
    def __init__(self,x,y,radius):
        self.x=x
        self.y=y
        self.radius=radius
        self.debugColor=(255,255,0)
    def collides(self,group,o,ogroup):
        relx=group.x-ogroup.x+self.x-o.x;
        rely=group.y-ogroup.y+self.y-o.y;
        relx=abs(relx)
        rely=abs(rely)
        if(isinstance(o, Circle)):
            return relx*relx+rely*rely<(self.radius+o.radius)**2
        else:
            if(relx<o.width/2):
                return rely<self.radius+o.height/2
            elif(rely<o.height/2):
                return relx<self.radius+o.width/2
            else:
                return (relx-o.width/2)**2+(rely-o.height/2)**2<self.radius**2

        return False
    def drawCollision(self,group, screen):
        pygame.draw.circle(screen, self.debugColor,(int(self.x+group.x), int(self.y+group.y)), int(self.radius) ,2)



class Collidable:
    def __init__(self,x,y,xvel,yvel):
        self.canColide=True;
        self.x=x
        self.y=y
        self.xvel=xvel
        self.yvel=yvel
        self.components=[]
    def drawCollision(self, screen):
        for subObject in self.components:
            subObject.drawCollision(self,screen)
    def update(self, delta):
        if(self.xvel != 0):
            self.xvel+=WallAccel*delta
        self.y+=self.yvel*delta
        self.x+=self.xvel*delta
    def collides(self,o):
        if not (self.canColide and o.canColide):
            return False
        collides=False;
        for selfob in self.components:
            for otho in o.components:
                collides=collides or selfob.collides(self,otho,o)
        return collides

class Bird(Collidable, Drawable):
    def __init__(self, sheet,x,y,xvel,yvel):
        Collidable.__init__(self,x,y,xvel,yvel)
        Drawable.__init__(self)
        self.gravity=BirdGravity
        self.components.append(Circle(0,0,20))
        self.sprites.append(AnimatedSprite(sheet,(3, 491, 17, 12),0, 0,  0, 0, 0, 3))
        self.rotation=0;
    def flap(self):
        self.yvel=BirdFlapVel
    def stop(self):
        self.gravity=BirdGravity;
        
    def update(self, delta):
        self.rotation=math.atan2(-WallSpeed, self.yvel)*180/math.pi-90;
        self.sprites[0].rotate(self.rotation)
        self.yvel+=self.gravity
        Collidable.update(self, delta)
        
class Wall(Collidable, Drawable):
    def __init__(self, sheet,x,y):
        Collidable.__init__(self, x,y,WallSpeed,0)
        Drawable.__init__(self)
        self.components.append(Rectangle(0,-240-WallGap,WallWidth,480))
        self.components.append(Rectangle(0,240,WallWidth,480))
        self.sprites.append(AnimatedSprite(sheet,(84, 323, 26, 160),0, 240,  0, 0, 0, 3))
        self.sprites.append(AnimatedSprite(sheet,(56, 323, 26, 160),0, -240-WallGap,  0, 0, 0, 3))
        for comp in self.components:
            comp.debugColor=(0,255,0)
class Goal(Collidable, Drawable):
    def __init__(self, x,):
         Collidable.__init__(self, x,0,WallSpeed,0);
         Drawable.__init__(self)
         self.components.append(Rectangle(50,Height/2,100,Height))
         for comp in self.components:
            comp.debugColor=(0,0,255)
    def activate(self):
        self.canColide=True;
    def complete(self):
        self.canColide=False;
class Score(Drawable):
    
    def __init__(self,sheet, x, y):
         Drawable.__init__(self)
         self.num=0;
         self.x=x+50;
         self.y=y+50;
         self.nums=[];
         self.nums.append(AnimatedSprite(sheet,(496, 60, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(135, 455, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(290, 160, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(304, 160, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(318, 160, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(332, 160, 12,  16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(290, 184, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(304, 184, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(318, 184, 12, 16),0,0,  0, 0, 0, 3));
         self.nums.append(AnimatedSprite(sheet,(332, 184, 12, 16),0,0,  0, 0, 0, 3));
         self.sprites.append(self.nums[0])
    def inc(self):
        self.num=self.num+1;
        if(self.num<10):
             self.sprites=[copy.copy(self.nums[self.num%10])]
        else:
            self.sprites=[copy.copy(self.nums[(self.num/10)%10]), copy.copy(self.nums[self.num%10])];
            self.sprites[1].x+=40;
        pass
        
