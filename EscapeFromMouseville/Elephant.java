
/**
 * The Elephant is a creature that has coordinates
 * in a maze It can move in that maze (up, down, 
 * left, right), and it also has a limited number 
 * of mousetraps that it can drop in the maze. 
 * (the elephant is indeed terrified of the deadly mice!)
 * 
 * @author Ryan Seys
 * @version 0.1
 */
public class Elephant
{
    // instance variables
    private static final int DEFAULT_MOUSETRAPS = 3;
    public int mousetraps = DEFAULT_MOUSETRAPS;

    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters
     */
    public Elephant(int x, int y, Mouseville m)
    {
        
        int mousetraps = DEFAULT_MOUSETRAPS;
        Mouseville maze;
    }
    
    /**
     * Assign the maze, and give an initial position (0, 0)
     */
    public Elephant(Mouseville m)
    {
        // initialise instance variables
        int x;
        int y;
        int mousetraps;
        Mouseville maze;
    }
    
    /**
     * Get the X-coordinate of the Elephant.
     */
    public int getX()
    {
        // put your code here
        return 0;
    }
    
    /**
     * Get the Y-coordinate of the Elephant.
     */
    public int getY()
    {
        // put your code here
        return 0;
    }
    
    public int inventory()
    {
        // put your code here
        return 0;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds, 
     * and can't jump or move diagonally.
     */
    public boolean canGoTo(int i, int j)
    {
        // put your code here
        return false;
    }
    
    /**
     * Move up if possible.
     */
    public void moveUp()
    {
        // put your code here
    }
    
    /**
     * Move down if possible.
     */
    public void moveDown()
    {
        // put your code here
    }
    
    /**
     * Move left if possible.
     */
    public void moveLeft()
    {
        // put your code here
    }
    
    /**
     * Move right if possible.
     */
    public void moveRight()
    {
        // put your code here
    }
    /**
     * Drop a mousetrap at the current coordiante 
     * update the inventory accordingly!
     */
    public void dropMousetrap()
    {
        // put your code here
    }
}
