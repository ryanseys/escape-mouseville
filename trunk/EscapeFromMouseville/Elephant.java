
/**
 * The Elephant is a creature that has coordinates
 * in a maze It can move in that maze (up, down, 
 * left, right), and it also has a limited number 
 * of mousetraps that it can drop in the maze. 
 * (the elephant is indeed terrified of the deadly mice!)
 * 
 * @author Ryan Seys
 * @version 0.2
 */
public class Elephant
{
    // instance variables
    private static final int DEFAULT_MOUSETRAPS = 3;
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
        x = 2;
        y = 1;
        mousetraps = DEFAULT_MOUSETRAPS;
        maze = m;
    }
    
    /**
     * Get the X-coordinate of the Elephant.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Get the Y-coordinate of the Elephant.
     */
    public int getY()
    {
        return y;
    }
    
    public int inventory()
    {
        return mousetraps;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds, 
     * and can't jump or move diagonally.
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
       else System.out.println("You cannot move there.");
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
       else System.out.println("You cannot move there.");
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
       else System.out.println("You cannot move there.");
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
       else System.out.println("You cannot move there.");
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
        else System.out.println("You don't have any more mousetraps left.");
    }
}
