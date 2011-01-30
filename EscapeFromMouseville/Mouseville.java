import java.awt.*;
/**
 * Mouseville is essentially a grid containing the elephant, 
 * an exit, and potentially a few mousetraps if dropped by the elephant.
 * 
 * @author Ryan Seys
 * @version 0.2
 */
public class Mouseville
{
    // instance variables
    public static final int SIZE = 5;
    public boolean grid[][];
    public Elephant e;
    Point exit;
    /**
     * Constructor for objects of class Mouseville
     */
    public Mouseville()
    {
        // initialise instance variables
        //initialized with a grid full of false values
        e = new Elephant(this);
        grid = new boolean[SIZE][SIZE];
        exit = new Point(3,2); // exit is given an set point. this can be changed later.
    }

    /**
     * @param  y   a sample parameter for a method
     * @return     a reference to the elephant.
     */
    public Elephant getElephant()
    {
        // put your code here
        return e;
    }
    
    /**
     * Set a mousetrap at the indicated coordinate.
     */
    public void setMousetrap(int x, int y) 
    {
        grid[x][y] = true;
    }
    
    /**
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
     * @returns true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        return false;
    }
    
    /**
     * Returns a string representation of the grid: 
     * - put an "X" at the location of the exit; 
     * - put a "E" if the elephant is at a given coordinate; 
     * - otherwise, put a "T" if there's a mousetrap at that coordinate; 
     * - otherwise, just print a dot "."
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
                    output = output + "X   "; //exit has precendence over elephant
                }
                else if ((i == e.getX()) && (j == e.getY()))
                {
                    output = output + "E   "; //elephant has precendence over traps.
                }
                else
                {
                    if (grid[i][j] == false)
                    {
                        output = output + ".   ";
                    }
                    else if (grid[i][j] == true)
                    {
                        output = output + "T   ";
                    }
                }
            }
            output = output + "\n\n";
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
