import java.util.ArrayList;
/**
 * PacmanMaze is a kind of maze that keeps track of containing dots.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class PacmanMaze extends Maze
{
    private static final String GHOST_STRING = "G";
    private static final String PAC_STRING = "P";
    private static final String DOT = "D";
    private static final String EMPTY = ".";

    /**
     * Initialize the dots and the count of dots left.
     */
    public PacmanMaze()
    {
        super();
    }

    /**
     * "Resolves" the new state of the game.
     */
    public void resolve()
    {
        eat(p.getX(), p.getY());
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print();
        System.out.print(COMMAND_REQUEST);
    }
    
    /**
     * Has Pacman eaten all the dots yet.
     * @return true if Pacman has eaten all the dots.
     */
    public boolean hasWon()
    {
        // if all dots are gone. (all grid are true)
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                if (!(hasDotAt(i,j)))
                {
                    return false;
                }
            }
        }
        return true;          
    }
    
    /**
     * Removes a 'dot' indicated by the supplied coordinates from the Grid.
     */
    public void eat(int i, int j) 
    {
        grid[i][j] = true;
    }

    /**
     * Returns a string representation of the grid: 
     * - put an "G" at the location of a Ghost
     * - put a "P" if Pacman is at a given coordinate; 
     * - print an "D" for an uneaten dot.
     * - print a "." for an eaten dot.
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
                if ((i == p.getX()) && (j == p.getY())) {
                    output = output + PAC_STRING + H_SPACER_STRING; 
                }
                else if (hasMonster(i,j))
                {
                    //ghost has precedence over pacman
                    output = output + GHOST_STRING + H_SPACER_STRING;
                }
                else if (hasWallAt(i,j)) {
                    output = output + WALL_STRING + H_SPACER_STRING;
                }
                else if (grid[i][j] == false)
                {
                        //non-eaten yet.
                        output = output + DOT + H_SPACER_STRING;
                }
                else if (grid[i][j] == true)
                {
                    //eaten
                    output = output + EMPTY + H_SPACER_STRING;
                }
            }
            output = output + V_SPACER_STRING;
        }
        return output;
    }
}