public class Lab3
{
    public static void testLightCandles1()
  {
    Robot.load("candles1.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles2()
  {
    Robot.load("candles2.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
    
  public static void lightCandles()
  {
    for(int d=10;d>0;d--){
     lightCandle();
     if(Robot.frontIsClear()){
         Robot.move();
         turn(3);
         for(int e=2;e>0;e--){
             if(Robot.frontIsClear()){
             Robot.move();
            }
        }
        turn(1);
    }
    }
  
  
  
  }
  
  //Run this method to test completeRoom on map room1.txt
  public static void testCompleteRoom1()
  {
     Robot.load("room1.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  //Run this method to test completeRoom on map room2.txt
  public static void testCompleteRoom2()
  {
    Robot.load("room2.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  //Complete this method.  You will need to write additional helper methods.
  public static void completeRoom()
  {
    int length=wallLength();
      for(int g=4; g>0;g--){
        gapFill();
          completeWall(length);
        turn(3);
    }
  
  
  
  }
  
  //Run this method to test swapAll on map swap1.txt
  public static void testSwapAll1()
  {
    Robot.load("swap1.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll2()
  {
    Robot.load("swap2.txt");
    Robot.setDelay(0.05);
    swapAll();
  }

  //Complete this method.  You will need to write additional helper methods.
  public static void swapAll()
  {
    int colorRight;
    int colorLeft;
    boolean keepMoving=true;
    while(keepMoving){
        colorRight=lightCheckRight();
        colorLeft=lightCheckLeft();
        turn(1);
        Robot.move();
        if(colorRight==0){
            if(!Robot.onDark()){
            Robot.makeDark();
        }
        }
        else{
            if(Robot.onDark()){
            Robot.makeLight();
        }
        }
        turn(2);
        Robot.move();
        Robot.move();
        if(colorLeft==0){
            if(!Robot.onDark()){
                Robot.makeDark();
        }
    }
        else{
            if(Robot.onDark()){
            Robot.makeLight();
        }
        }
        turn(2);
        Robot.move();
        turn(3);
        if(Robot.frontIsClear()){
            Robot.move();
        }
        else{
            keepMoving=false;
    }
    }
  }
  
  //Don't run these. I will!
  public static void testLightCandles3()
  {
    Robot.load("candles3.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  
  public static void testLightCandles4()
  {
    Robot.load("candles4.txt");
    Robot.setDelay(0.05);
    lightCandles();
  }
  public static void testCompleteRoom3()
  {
     Robot.load("room3.txt");
     Robot.setDelay(0.05);
     completeRoom();
  }
  
  public static void testCompleteRoom4()
  {
    Robot.load("room4.txt");
    Robot.setDelay(0.05);
    completeRoom();
  }
  
  public static void testSwapAll3()
  {
    Robot.load("swap3.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  
  //Run this method to test swapAll on map swap2.txt
  public static void testSwapAll4()
  {
    Robot.load("swap4.txt");
    Robot.setDelay(0.05);
    swapAll();
  }
  public static void turn(int a){
     for(int b=a;b>0;b--){
         Robot.turnLeft();
        }
    }
    public static void lightCandle(){    //Pre: There is a candle in front of the robot
     for(int c=2;c>0;c--){               //Post: The candle in front of the robot is lit
         if(!Robot.frontIsClear()){
         Robot.turnLeft();
         Robot.move();
         turn(3);
        }
    }
    Robot.move();
    Robot.makeDark();
    }
    public static void gapFill(){  //Pre: The robot is in front of a gap
        turn(1);                    //Post: The gap is filled, and the robot is where it started
        if(Robot.frontIsClear()){
            Robot.move();
            if(!Robot.onDark()){
                Robot.makeDark();
            }
            turn(2);
            Robot.move();
            turn(1);
        }
        else{
         turn(3);   
        }
    }
    public static void completeWall(int size){  //Pre: The robot is near an incomplete wall
        for(int f=size;f>0;f--){                //Post: The wall is filled, and the robot is at the end of the wall
        Robot.move();
        gapFill();
    }
}
     public static int wallLength(){    //Pre: The robot is next to a wall whose length is unknown
         int h=0;                       //Post: The function returns the length of the wall and the robot is back where it started
         int blockBehind=1;
         turn(2);
         if(Robot.frontIsClear()){
             h++;
             blockBehind=0;
            }
            
            turn(2);
            
                while(Robot.frontIsClear()){
                    h++;
                    Robot.move();
                }
                
                    if(blockBehind==0){
                        h--;
                    }
                    turn(2);
                    for(int j=h;j>0;j--){
                        Robot.move();
                    }
                    if(blockBehind==1){
                        h--;
                    }
                    turn(2);
                
            
            return h;
        }
        public static int lightCheckLeft(){ //Pre: The robot does not know the state of lightness of the block to its left
            int leftLight;                  //Post: The robot knows the state of lightness of the block to its left
            turn(1);
            Robot.move();
            if(!Robot.onDark()){
                leftLight=1;
        }
        else{
            leftLight=0;
        }
        turn(2);
        Robot.move();
        turn(1);
        return leftLight;
}
public static int lightCheckRight(){ //Pre: The robot does not know the state of lightness of the block to its right
    int rightLight;                  //Post: The robot knows the state of lightness of the block to its right
    turn(3);
    Robot.move();
    if(Robot.onDark()){
        rightLight=0;
}
else{
    rightLight=1;
}
turn(2);
        Robot.move();
        turn(3);
        return rightLight;
}
}
    
