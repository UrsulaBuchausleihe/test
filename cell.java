import greenfoot.*;

public class cell extends Actor
{
    public boolean leben;
    
    public cell(int l)
    {
        if(l == 0) dead();
        if(l == 1) alive();
    }   
    
    public void alive()
    {
        setImage("cell_l.png");
        leben = true;
    }
    
    public void dead()
    {
        setImage("cell_d.png");
        leben = false;
    }
    
    public void update()
    {
        if(leben == true)
        {
            dead();
        }
        else
        {
            alive();
        }
    }
    
    public boolean gibStatus()
    {
        return leben;
    }
    
    public void act()
    {
        if( Greenfoot.mouseClicked(this) )
        {
            update();
        }        
    }
}
