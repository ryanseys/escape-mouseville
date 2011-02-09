
/**
 * Write a description of class Mouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mouse
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Mouseville maze;

    /**
     * Constructor for objects of class Mouse
     */
    public Mouse(int x, int y, Mouseville m)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        maze = new Mouseville();
        
    }

    /**
     * Method description
     * 
     * @return     X coordinate of mouse.
     */
    public int getX()
    {
        //return x value of mouse
        return 0;
    }
    
    /**
     * Method description
     * 
     * @return     Y coordinate of mouse.
     */
    public int getY()
    {
        //return y value of mouse
        return 0;
    }
    
    /**
     * Method description
     * 
     * @return true if it can go there, false if it can't.
     */
    public boolean canGoTo(int i, int j)
    {
        //return whether it can go there.
        return false;
    }
    
    public void move()
    {
        //move mouse
    }
}
