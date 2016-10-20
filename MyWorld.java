import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    cell[][] world;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        super(60, 40, 10);
        
        world = new cell[60][40];
        
        for(int x=0; x<60; x++)
        {
            for(int y=0; y<40;y++)
            {
                if(Greenfoot.getRandomNumber(99)<25)
                {
                    world[x][y] = new cell(0);
                    addObject(world[x][y], x,y);
                }
                else
                {
                    world[x][y] = new cell(0);
                    addObject(world[x][y],x,y);
                }
            }
        }
    }
    
    public void nextGeneration()
    {
        int[][] newWorld = new int[60][40];
        
        for( int x=0; x<60;x++)
        {
                for(int y=0; y<40;y++)
                {
                    int n = numberOfNeighbors(x,y);

                    if(n==3)
                    {
                        newWorld[x][y] = 1;
                    }

                    
                    if(n<2)
                    {
                        newWorld[x][y] = 0;
                    }
                    if(n== 2 && world[x][y].gibStatus() == true)
                    {
                        newWorld[x][y] = 1;
                    }
                    if(n== 2 && world[x][y].gibStatus() == false)
                    {
                        newWorld[x][y] = 0;
                    }
                    if(n>= 4)
                    {
                        newWorld[x][y] = 0;
                    }
                    
                }          
            }
        
            
        for( int x=0; x<60;x++)
        {
                for(int y=0; y<40;y++)
                {
                    if(newWorld[x][y]==1) world[x][y].alive(); else  world[x][y].dead();
                }
                
        }
        
    }
    
    public int numberOfNeighbors(int x, int y)
    {
        int sum = 0;
        
        if (x-1>=0 && y-1>=0 && world[x-1][y-1].gibStatus() == true) sum++;
        if (y-1>=0 && world[x][y-1].gibStatus() == true) sum++;
        if (x+1<60 && y-1>=0 && world[x+1][y-1].gibStatus() == true) sum++;
        if (x-1>=0 && world[x-1][y].gibStatus() == true) sum++;
        if (x+1<60 && world[x+1][y].gibStatus() == true) sum++;
        if (x-1>=0 && y+1<40 && world[x-1][y+1].gibStatus() == true) sum++;
        if (y+1<40 && world[x][y+1].gibStatus() == true) sum++;
        if (x+1<60 && y+1<40 && world[x+1][y+1].gibStatus() == true) sum++;
        
        return sum;
    }
    
    public void act()
    {
        if( Greenfoot.isKeyDown("n") )
        {
            nextGeneration();
        }
    }
}
