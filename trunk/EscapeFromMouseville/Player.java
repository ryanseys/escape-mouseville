
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Creature
{
    // instance variables - replace the example below with your own
    
    private static final String ERROR_MOVE = "You cannot move there.";
    private static final String INVALID_CMD = "Invalid command";
    private static final String QUIT_RESPONSE = "You have quit.";
    /**
     * Constructor for objects of class Player
     */
    public Player(Maze m)
    {
        super(m);
    }

    /**
     * Constructor for objects of class Player
     */
    public Player(int x, int y, Maze m)
    {
        super(x, y, m);
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
