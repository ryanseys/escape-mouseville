/**
 * A Ghost chases Pacman around a PacmanGame.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost
{
    // instance variables
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
    
    /**
     * Move one step in the general direction of the elephant.
     */
    public void move()
    {
        // Four cases: Move left, right, up or down of Pacman.
        // quite possibly the laziest move algorithm ever.
        // although lazy, this algorithm is very efficient
        // making it very hard to win.
        if (this.getY() > maze.getPacman().getY()) //pacman is above
        { 
            y -= 1; //move up
        }
        else if (this.getY() < maze.getPacman().getY()) //pacman is below
        {
            y += 1; //move down
        }
        else if (this.getX() < maze.getPacman().getX()) //pacman on right
        {
            x += 1; //move right
        }
        else if (this.getX() > maze.getPacman().getX()) //pacman on left
        {
            x -= 1; //move left
        }
        else
        {
            //ON TOP OF PACMAN! :O (this is handled elsewhere but functionality can be added here).
        }
    }
}