/**
 * Pacman tries to collect all the dots from the gameboard
 * without getting attacked by the ghost that is following him.
 * 
 * @author Ryan Seys 
 * @version 1.0
 */
public class Pacman
{
    // instance variables
    private int x;
    private int y;
    private PacmanMaze maze;
    private static final int DEFAULT_X = 2;
    private static final int DEFAULT_Y = 2;
    private static final String ERROR_MOVE = "You cannot move there.";
    private static final String QUIT_RESPONSE = "You have quit.";
    private static final String INVALID_CMD = "Invalid command";

    /**
     * Constructor for objects of class Pacman
     */
    public Pacman(int x, int y, PacmanMaze m)
    {
        this.x = x;
        this.y = y;
        maze = m;
    }

    /**
     * Assign the maze, and give an initial position (0, 0)
     */
    public Pacman(PacmanMaze m)
    {
        // initialise instance variables
        maze = m;
        x = DEFAULT_X;
        y = DEFAULT_Y;
    }
    
    /**
     * Get the X-coordinate of Pacman.
     * 
     * @return The x-coordinate of pacman.
     */
    public int getX()
    {
        return x;
    }
    
    /**
     * Get the Y-coordinate of Pacman.
     * 
     * @return The y-coordinate of pacman.
     */
    public int getY()
    {
        return y;
    }
    
    /**
     * Tests to see if the move is valid: can't go outside the bounds, 
     * and can't jump or move diagonally.
     * 
     * @param i The x value of where you want pacman to go.
     * @param j The y value of where you want pacman to go.
     * @return true if pacman can move there.
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
           maze.grid[getX()][y] = true;
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
           maze.grid[getX()][y] = true;
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
           maze.grid[x][getY()] = true;
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
           maze.grid[x][getY()] = true;
       }
       else System.out.println(ERROR_MOVE);
    }
    
    /**
     * Process user input: character 
     * 'w' means move up character 
     * 'z' means move down character
     * 'a' means move left character 
     * 's' means move right character
     */
    public void processCommand(char c) 
    {
        if (c == 'w')
        {
            moveUp();
        }
        else if (c == 'z')
        {
            moveDown();
        }
        else if (c == 'a')
        {
            moveLeft();
        }
        else if (c == 's')
        {
            moveRight();
        }
        else if (c == 'q')
        {
            System.out.print("\f"); //form feed "clears" the display (At least on Mac).
            System.out.println(QUIT_RESPONSE);
            System.exit(0);
        }
        else
        {
            System.out.println(INVALID_CMD);
        }
    }
}
