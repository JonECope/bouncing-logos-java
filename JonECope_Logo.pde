//JonECope

// Variables
int backgroundC = 0;
boolean backgroundChange = false;
int colorChange = 100;
int xdirection = 1;  // Left or Right
int ydirection = 1;  // Top to Bottom
Shape[] shapes = new Shape[50];


void setup()
{
 size(1200, 800);
 
 for (int i = 0; i < 10; i++)
 {
    shapes[i] = new Shape(3, random(width), random(height), 50, color(random(15), random(15), random(255), random(255)), 4.4, 3.6, xdirection, ydirection);
 }
}

void draw()
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

void mousePressed()
{
 for (int i = 0; i < 10; i++)
 {
  shapes[i].type = int(random(4));
  shapes[i].randomizeColor(); 
 }
}
