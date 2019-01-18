import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class JonECope_Logo extends PApplet {

//JonECope

// Variables
int backgroundC = 0;
boolean backgroundChange = false;
int colorChange = 100;
int xdirection = 1;  // Left or Right
int ydirection = 1;  // Top to Bottom
Shape[] shapes = new Shape[50];


public void setup()
{
 
 
 for (int i = 0; i < 10; i++)
 {
    shapes[i] = new Shape(3, random(width), random(height), 50, color(random(15), random(15), random(255), random(255)), 4.4f, 3.6f, xdirection, ydirection);
 }
}

public void draw()
{
  background(colorChange, 0, 0);
  
 if (backgroundChange == false){
   backgroundC++;
   colorChange+=1;
   if (backgroundC == 50) {
     backgroundChange = true;
   }
 }
   
 if (backgroundChange == true){
   backgroundC--;
   colorChange-=1;
   if (backgroundC == 0) {
     backgroundChange = false;
   }
 }
 
 for (int i = 0; i < 10; i++)
 {
  shapes[i].draw();
  shapes[i].movePosition();
  shapes[i].accelPosition();
 }
}

public void mousePressed()
{
 for (int i = 0; i < 10; i++)
 {
  shapes[i].type = PApplet.parseInt(random(4));
  shapes[i].randomizeColor(); 
 }
}
class Shape
{
PImage JLogo;
int type;
float x, y, size;
int c;
int rad = 0;

float xspeed = 2.8f;  // Speed of the shape
float yspeed = 2.2f;  // Speed of the shape

int xdirection = 1;  // Left or Right
int ydirection = 1;  // Top to Bottom

public void setup()
{
 x = random(width/2);
 y = random(height/2);
 JLogo = loadImage("JonECopeJ.png");
}

 Shape(int type, float x, float y, float size, int c, float xspeed, float yspeed, int xdirection, int ydirection)
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
 
 public void draw()
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
 
 public void randomizeColor()
 {
   int[] name = {color(255, 255, 255, 150), color(255, 255, 255, 255), color(0, 0, 0, 150), color(255, 15, 15, 150), color(255, 0, 0, 150)};
   c = color(name[PApplet.parseInt(random(5))]);
 }
 
 public void movePosition()
 {
  x = x + ( xspeed * xdirection );
  y = y + ( yspeed * ydirection );
 }
 
 public void accelPosition()
 {
  if (x > width-rad || x < rad) {
    xdirection *= -1;
  }
  if (y > height-rad || y < rad) {
    ydirection *= -1;
  }
 }
}
  public void settings() {  size(1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "JonECope_Logo" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
