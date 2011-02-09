/**
 * The Elephant is a creature that has coordinates
 * in a maze It can move in that maze (up, down, 
 * left, right), and it also has a limited number 
 * of mousetraps that it can drop in the maze. 
 * (the elephant is indeed terrified of the deadly mice!)
 * 
 * @author Ryan Seys
 * @version 1.1
 */
public class Elephant
{
    // instance variables
    private static final int DEFAULT_MOUSETRAPS = 3;
    private static final String ERROR_MOVE = "You cannot move there.";
    private static final String NO_MTRAPS = "You don't have any more mousetraps left.";
    private static final int DEFAULT_X = 2;
    private static final int DEFAULT_Y = 2;
    private int mousetraps;
    private Mouseville maze;
    private int x;
    private int y;
    
    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters
     */
    public Elephant(int x, int y, Mouseville m)
    {
        this.x = x;
        this.y = y;
        mousetraps = DEFAULT_MOUSETRAPS;
        maze = m;
    }
    
    /**
     * Assign the maze, and give an initial position (0, 0)
     */
    public Elephant(Mouseville m)
    {
        // initialise instance variables
        x = DEFAULT_X;
        y = DEFAULT_Y;
        mousetraps = DEFAULT_MOUSETRAPS;
        maze = m;
    }
    
    /**
     * Get the X-coordinate of the Elephant.
     * 
     * @return The x-coordinate of the elephant.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Get the Y-coordinate of the Elephant.
     * 
     * @return The y-coordinate of the elephant.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Get how many mousetraps are left to use.
     * 
     * @return The amount of mousetraps the elephant still has.
     */
    public int inventory()
    {
        return mousetraps;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds, 
     * and can't jump or move diagonally.
     * 
     * @param i The x value of where you want the elephant to go.
     * @param j The y value of where you want the elephant to go.
     * @return true if the elephant can move there.
     */
    public boolean canGoTo(int i, int j)
    {
        //you can subtract or add from one or the other of the two coordinates but not both. (4 cases)
        if (getY() == j)
        {
            //check x
            if ((getX() - 1) == i)
            {
                if ((i <= (maze.SIZE - 1)) && (i >= 0)) //not out of bounds
                {
                    return true;
                }
            }
            else if ((getX() + 1) == i)
            {
                if ((i <= (maze.SIZE - 1)) && (i >= 0)) //not out of bounds
                {
                    return true;
                }
            }
        }
        else if (getX() == i)
        {
            if ((getY() - 1) == j)
            {
                if ((j <= (maze.SIZE - 1)) && (j >= 0)) //not out of bounds
                {
                    return true;
                }
            }
            else if ((getY() + 1) == j)
            {
                if ((j <= (maze.SIZE - 1)) && (j >= 0)) //not out of bounds
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Move up if possible.
     */
    public void moveUp()
    {
       if(canGoTo(getX(),(getY() - 1)))
       {
           y = (getY() - 1);
       }
       else System.out.println(ERROR_MOVE);
    }
    
    /**
     * Move down if possible.
     */
    public void moveDown()
    {
       if(canGoTo(getX(),(getY() + 1)))
       {
           y = (getY() + 1);
       }
       else System.out.println(ERROR_MOVE);
    }
    
    /**
     * Move left if possible.
     */
    public void moveLeft()
    {
       if(canGoTo((getX() - 1),getY()))
       {
           x = (getX() - 1);
       }
       else System.out.println(ERROR_MOVE);
    }
    
    /**
     * Move right if possible.
     */
    public void moveRight()
    {
       if(canGoTo((getX() + 1),getY()))
       {
           x = (getX() + 1);
       }
       else System.out.println(ERROR_MOVE);
    }
    
    /**
     * Drop a mousetrap at the current coordiante 
     * update the inventory accordingly!
     */
    public void dropMousetrap()
    {
        if (inventory() > 0)
        {
            maze.setMousetrap(getX(), getY());
            mousetraps = inventory() - 1;
        }
        else System.out.println(NO_MTRAPS);
    }
    
    /**
     * Process user input: character 
     * 'w' means move up character 
     * 'z' means move down character
     * 'a' means move left character 
     * 's' means move right character
     * 'm' means drop a mousetrap
     */
    public void processCommand(char c) 
    {
        //process
    }
}
