import java.awt.*; // The Point class needs this.
import java.util.ArrayList;
/**
 * Mouseville is essentially a grid containing the elephant, 
 * an exit, and potentially a few mousetraps if dropped by the elephant.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Mouseville extends Maze
{
    // instance variables
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
        super();
        exit = new Point(DEFAULT_EXIT_X,DEFAULT_EXIT_Y); // exit is given an set point. this can be changed later.
    }

    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        int index = 0;
        boolean toRemove = false;
        for (Monster m : monsters)
        {
             if (hasDotAt(m.getX(), m.getY()))
             {
                 grid[m.getX()][m.getY()] = false; //remove trap from grid.
                 index = monsters.indexOf(m); //remove mouse from list.
                 toRemove = true;
             }
        }
        if (toRemove)
        {
            monsters.remove(index); //works only with 1 value right now
        }
        
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print();
        System.out.print(COMMAND_REQUEST);
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
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        if ((exit.getX() == p.getX()) && (exit.getY() == p.getY()))
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
                // Note: The order of the following IF statements controls precedence over which letter
                // is displayed when two objects overlap.
                if (hasMonster(i,j)) {
                    output = output + MOUSE_STRING + H_SPACER_STRING;
                }
                else if ((i == exit.getX()) && (j == exit.getY()))
                {
                    //exit has precendence over elephant
                    output = output + EXIT_STRING + H_SPACER_STRING; 
                }
                else if ((i == p.getX()) && (j == p.getY()))
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