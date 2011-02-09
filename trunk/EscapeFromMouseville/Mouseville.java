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
     * Constructor for objects of class Mouseville
     */
    public Mouseville()
    {
        //initialized a grid full of false values
        mice = new ArrayList<Mouse>();
        grid = new boolean[SIZE][SIZE];
        e = new Elephant(this);
        exit = new Point(DEFAULT_EXIT_X,DEFAULT_EXIT_Y); // exit is given an set point. this can be changed later.
    }

    /**
     * Fetch and return the elephant object.
     * @return     a reference to the elephant.
     */
    public Elephant getElephant()
    {
        return e;
    }
    
    public ArrayList<Mouse> getMice() 
    {
        return mice;
    }
    
    public void addMouse(Mouse m)
    {
        //add mouse
    }
    
    public boolean hasMouseAt(int i, int j)
    {
        //does it have a mouse at (x,y)
        return false;
    }
    
    public void resolve()
    {
        //resolve?
    }
    
    public boolean hasLost()
    {
        //have you lost?
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
     * @returns true if there is a mousetrap at the indicated coordinate.
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
     * 
     * @returns true if the elephant has reached the exit.
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
                if ((i == exit.getX()) && (j == exit.getY()))
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
