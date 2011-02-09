import java.awt.*; // The Point class needs this.
import java.util.ArrayList;
/**
 * Mouseville is essentially a grid containing the elephant, 
 * an exit, and potentially a few mousetraps if dropped by the elephant.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Mouseville
{
    // instance variables
    public static final int SIZE = 5;
    public boolean grid[][];
    public Elephant e;
    private ArrayList<Mouse> mice;
    private static final int DEFAULT_EXIT_X = 3;
    private static final int DEFAULT_EXIT_Y = 4;
    private static final String MOUSE_STRING = "M";
    private static final String EXIT_STRING = "X";
    private static final String ELEPHANT_STRING = "E";
    private static final String TRAP_STRING = "T";
    private static final String EMPTY_SPACE_STRING = ".";
    // horizontal spacer to make it look like a square
    private static final String H_SPACER_STRING = "   "; 
    // vertical spacer to make it look like a square
    private static final String V_SPACER_STRING = "\n\n"; 
    Point exit;
    
    /**
     * Initialize the elephant, the mice, the grid, and the exit (middle of the grid).
     * - the grid is an array of booleans, where "true" means there's a mousetrap.
     * - the mice are stored in an arraylist (you can create a few here).
     * - the exit is a Point (from the java.awt package), used to represent coordinates.
     */
    public Mouseville()
    {
        //initialized a grid full of false values
        mice = new ArrayList<Mouse>();
        Mouse m1 = new Mouse(this); //create a mouse
        mice.add(m1); //add it to the list
        grid = new boolean[SIZE][SIZE];
        e = new Elephant(this);
        exit = new Point(DEFAULT_EXIT_X,DEFAULT_EXIT_Y); // exit is given an set point. this can be changed later.
    }

    /**
     * Fetch and return the elephant object.
     * @return A reference to the elephant.
     */
    public Elephant getElephant()
    {
        return e;
    }
    
    /**
     * All the mice created.
     * @return The ArrayList of mice.
     */
    public ArrayList<Mouse> getMice() 
    {
        return mice;
    }
    
    /**
     * Add a mouse to the list of mice
     * @param Mouse to add.
     */
    public void addMouse(Mouse m)
    {
        mice.add(m);
    }
    
    /**
     * Whether or not there is a mouse at the coordinate.
     * @return True if there is a mouse there, false if there isn't.
     */
    public boolean hasMouseAt(int i, int j)
    {
        for (Mouse m : mice)
        {
            if ((i == m.getX()) && (j == m.getY()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        int index = 0;
        boolean toRemove = false;
        for (Mouse m : mice)
        {
             if (hasMouseTrap(m.getX(), m.getY()))
             {
                 grid[m.getX()][m.getY()] = false; //remove trap from grid.
                 index = mice.indexOf(m); //remove mouse from list.
                 toRemove = true;
             }
        }
        if (toRemove)
        {
            mice.remove(index); //works only with 1 value right now
        }
        
        System.out.print("\f");
        print();
        System.out.print("Enter a command: ");
    }
    
    /**
     * Has the elephant got caught by a mouse yet.
     * @return true if the elephant has got caught.
     */
    public boolean hasLost()
    {
        for (Mouse m : mice)
        {
            if (hasMouseAt(e.getX(), e.getY()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Set a mousetrap at the indicated coordinate.
     * @param  x   x-coordinate to set the trap at.
     * @param  y   y-coordinate to set the trap at.
     */
    public void setMousetrap(int x, int y) 
    {
        grid[x][y] = true;
    }
    
    /**
     * Checks if a coordinate has a mousetrap on it.
     * @param  x   x-coordinate to check for a trap.
     * @param  y   y-coordinate to check for a trap.
     * @return true if there is a mousetrap at the indicated coordinate.
     */
    public boolean hasMouseTrap(int x, int y)
    {
        if(grid[x][y] == true)
        {
            return true;
        }
        else return false;
    }
    
    /**
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        if ((exit.getX() == e.getX()) && (exit.getY() == e.getY()))
        {
            return true;
        }
        else return false;
    }
    
    /**
     * Returns a string representation of the grid: 
     * - put an "M" at the location of a mouse.
     * - put an "X" at the location of the exit; 
     * - put a "E" if the elephant is at a given coordinate; 
     * - otherwise, put a "T" if there's a mousetrap at that coordinate; 
     * - otherwise, just print a dot "."
     * @return A string representation of the grid.
     */
    public String toString()
    {
        String output = ""; //initialize
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                if (hasMouseAt(i,j)) {
                    output = output + MOUSE_STRING + H_SPACER_STRING;
                }
                else if ((i == exit.getX()) && (j == exit.getY()))
                {
                    //exit has precendence over elephant
                    output = output + EXIT_STRING + H_SPACER_STRING; 
                }
                else if ((i == e.getX()) && (j == e.getY()))
                {
                    //elephant has precendence over traps.
                    output = output + ELEPHANT_STRING + H_SPACER_STRING; 
                }
                else
                {
                    if (grid[i][j] == false)
                    {
                        //empty spot
                        output = output + EMPTY_SPACE_STRING + H_SPACER_STRING;
                    }
                    else if (grid[i][j] == true)
                    {
                        //trap!
                        output = output + TRAP_STRING + H_SPACER_STRING;
                    }
                }
            }
            output = output + V_SPACER_STRING;
        }
        return output;
    }
    
    /**
     * Ouput a string representation of the grid to the console.
     */
    public void print()
    {
        System.out.println(toString());
    }
}
