
/**
 * Write a description of class Creature here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creature
{
    // instance variables - replace the example below with your own
    protected int x;
    protected int y;
    public Maze maze;

    /**
     * Constructor for objects of class Creature
     */
    public Creature(Maze m)
    {
        x = 0;
        y = 0;
        maze = m;
    }
    
    /**
     * Constructor for objects of class Creature
     */
    public Creature(int x, int y, Maze m)
    {
        this.x = x;
        this.y = y;
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
}
