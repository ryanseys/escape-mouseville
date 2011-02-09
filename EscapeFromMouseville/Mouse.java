/**
 * A Mouse chases Elephant objects around a Mouseville.
 * 
 * @author Ryan Seys 
 * @version 1.0
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
        return x;
    }
    
    /**
     * Get Y coodinate of mouse.
     * 
     * @return Y coordinate of mouse.
     */
    public int getY()
    {
        //return y value of mouse
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
    
    /**
     * Move one step in the general direction of the elephant.
     */
    public void move()
    {
        // Four cases: Move left, right, up or down of Elephant.
        // quite possibly the laziest move algorithm ever.
        if (this.getY() > maze.getElephant().getY()) //elephant is above
        { 
            y -= 1; //move up
        }
        else if (this.getY() < maze.getElephant().getY()) //elephant is below
        {
            y += 1; //move down
        }
        else if (this.getX() < maze.getElephant().getX()) //elephant on right
        {
            x += 1; //move right
        }
        else if (this.getX() > maze.getElephant().getX()) //elephant on left
        {
            x -= 1; //move left
        }
        else
        {
            //ON TOP OF ELEPHANT! :O (this is handled elsewhere but functionality can be added here).
        }
    }
}