
/**
 * A Mouse chases Elephant objects around a Mouseville.
 * 
 * @author Ryan Seys 
 * @version 0.1
 */
public class Mouse
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private Mouseville maze;

    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters.
     */
    public Mouse(int x, int y, Mouseville m)
    {
        // initialise instance variables
        this.x = x; //assigns class x the value of parameter x
        this.y = y; //assigns class y the value of parameter y
        maze = m;
        
    }
    /**
     * Assign the maze, and give an initial position (0, 0).
     */
    public Mouse(Mouseville m)
    {
        maze = m;
        x = 0;
        y = 0;
    }

    /**
     * Get X coordinate of mouse.
     * 
     * @return X coordinate of mouse.
     */
    public int getX()
    {
        //return x value of mouse
        return 0;
    }
    
    /**
     * Get Y coodinate of mouse.
     * 
     * @return Y coordinate of mouse.
     */
    public int getY()
    {
        //return y value of mouse
        return 0;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds,
     * and can't jump or move diagonally.
     * 
     * @return true if it can go there, false if it can't.
     */
    public boolean canGoTo(int i, int j)
    {
        //return whether it can go there.
        return false;
    }
    /**
     * Move one step in the general direction of the elephant.
     */
    public void move()
    {
        //move mouse
    }
}
