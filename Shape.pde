class Shape
{
PImage JLogo;
int type;
float x, y, size;
color c;
int rad = 0;

float xspeed = 2.8;  // Speed of the shape
float yspeed = 2.2;  // Speed of the shape

int xdirection = 1;  // Left or Right
int ydirection = 1;  // Top to Bottom

void setup()
{
 x = random(width/2);
 y = random(height/2);
 JLogo = loadImage("JonECopeJ.png");
}

 Shape(int type, float x, float y, float size, color c, float xspeed, float yspeed, int xdirection, int ydirection)
 {
   this.type = type;
   this.x = x;
   this.y = y;
   this.size = size;
   this.c = c;
   this.xspeed = xspeed;
   this.yspeed = yspeed;
   this.xdirection = xdirection;
   this.ydirection = ydirection;
   
 }
 
 void draw()
 {
  fill(c);
  JLogo = loadImage("JonECopeJ.png");
  switch(type) // 0 = arc, 1 = rect, 2 = ellipse, 3 = triangle
  {
    case 0:
      arc(x, y, size, size, 0, PI);
      break;
    case 1:
      rectMode(CENTER);
      rect(x, y, size, size);
      break;
    case 2:
      ellipse(x, y, size, size);
      break;
    case 3:
      image(JLogo, x, y);
      imageMode(CENTER);
      stroke(255, 0, 0);
      break;
    case 4:
      triangle(x, y, size, size, 0, PI);
      break;
      
  }
 }
 
 void randomizeColor()
 {
   color[] name = {color(255, 255, 255, 150), color(255, 255, 255, 255), color(0, 0, 0, 150), color(255, 15, 15, 150), color(255, 0, 0, 150)};
   c = color(name[int(random(5))]);
 }
 
 void movePosition()
 {
  x = x + ( xspeed * xdirection );
  y = y + ( yspeed * ydirection );
 }
 
 void accelPosition()
 {
  if (x > width-rad || x < rad) {
    xdirection *= -1;
  }
  if (y > height-rad || y < rad) {
    ydirection *= -1;
  }
 }
}
