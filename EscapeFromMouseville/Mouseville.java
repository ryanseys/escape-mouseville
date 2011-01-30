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
    /**
     * Constructor for objects of class Mouseville
     */
    public Mouseville()
    {
        // initialise instance variables
        //initialized with a grid full of false values
        grid = new boolean[SIZE][SIZE];
        Point exit;
    }

    /**
     * @param  y   a sample parameter for a method
     * @return     a reference to the elephant.
     */
    public /*Elephant*/ int getElephant()
    {
        // put your code here
        return 0;
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
        return false;
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
        for(int i = 0; i < SIZE; i++)
        {
            for(int j = 0; j < SIZE; j++)
            {
                if (grid[i][j] == false)
                {
                    output = output + ".   ";
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
