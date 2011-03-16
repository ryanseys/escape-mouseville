import java.util.Random;
/**
 * Player represents the player, which is a creature that moves based on the user's input 
 * (for example, Pacman can be substituted with Player)
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Player extends Creature
{
    private static final String ERROR_MOVE = "You cannot move there.";
    private static final String INVALID_CMD = "Invalid command";
    private static final String QUIT_RESPONSE = "You have quit.";
    /**
     *  Assign the maze, and give an initial position (0, 0).
     */
    public Player(Maze m)
    {
        super(m);
    }

    /**
     * Assign the maze and set the coordinates to the ones supplied by the parameters.
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
       System.out.println("ASFAJFAJGJNsdjlganljls");
       if(canGoTo(getX(),(getY() + 1)))
       {
           System.out.println("GOES IN THE IF!");
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
    
    public void dig()
    {
        if(!(maze.grid[getX()][getY()] instanceof Hole)) {
            //don't dig, nothing there.
        }
        else {
            maze.grid[getX()][getY()] = null;
            Random r = new Random();
            r.setSeed(System.currentTimeMillis());
            int num = r.nextInt(5);
            if(num == 0) {
                System.out.println("0");
                maze.addPoints(100);
                
                //maze.setMsg("You gained 100 points!");
            }
            else if((num == 1) || (num == 4)) {
                System.out.println("0 or 4");
                maze.addMonster(new Monster(0,4, maze));
                //maze.setMsg("A monster appeared!");
            }
            else if(num == 2) {
                System.out.println("2");
                maze.addPoints(-500);
            }
            else if(num == 3) {
                System.out.println("3");
                maze.addPoints(500);
            }
        }
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
        else if (c == 'd')
        {
            dig();
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