
/**
 * Write a description of class Ghost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private PacmanMaze maze;

    /**
     * Constructor for objects of class Ghost
     */
    public Ghost(PacmanMaze pm)
    {
        x = 0;
        y = 0;
        maze = pm;
    }
    
    /**
     * Constructor for objects of class Ghost with coordinates.
     */
    public Ghost(int x, int y, PacmanMaze pm)
    {
        this.x = x;
        this.y = y;
        maze = pm;
    }

    /**
     * @return The X coordinate of the ghost.
     */
    public int getX()
    {
        // put your code here
        return x;
    }
    
    /**
     * @return The Y coordinate of the ghost.
     */
    public int getY()
    {
        // put your code here
        return y;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds,
     * and can't jump or move diagonally.
     * 
     * @return true if it can go there, false if it can't.
     */
    public boolean canGoTo(int i, int j)
    {
        // *** NOTE: THIS HAS BEEN COPY AND PASTED FROM ELEPHANT ***
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
}
