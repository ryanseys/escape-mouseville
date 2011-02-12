import java.util.ArrayList;
/**
 * Write a description of class PacmanMaze here.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class PacmanMaze
{
    // instance variables
    private int x;
    public static final int SIZE = 5;
    public boolean grid[][];
    private ArrayList<Ghost> ghosts;
    public Pacman p;
    private static final String GHOST_STRING = "G";
    private static final String PAC_STRING = "P";
    private static final String DOT = "o";
    private static final String EMPTY = ".";
    // horizontal spacer to make it look like a square
    private static final String H_SPACER_STRING = "   ";
    // vertical spacer to make it look like a square
    private static final String V_SPACER_STRING = "\n\n";
    private static final String COMMAND_REQUEST = "Enter a command: ";

    /**
     * Constructor for objects of class PacmanMaze
     */
    public PacmanMaze()
    {
        ghosts = new ArrayList<Ghost>();
        Ghost g1 = new Ghost(this); //create a mouse
        ghosts.add(g1); //add it to the list
        grid = new boolean[SIZE][SIZE];
        p = new Pacman(this);
    }
    
    /**
     * Fetch and return the Pacman object.
     * @return A reference to the pacman.
     */
    public Pacman getPacman()
    {
        return p;
    }
    
    /**
     * All the ghosts created.
     * @return The ArrayList of ghosts.
     */
    public ArrayList<Ghost> getGhosts() 
    {
        return ghosts;
    }
    
    /**
     * Add a ghost to the list of ghosts.
     * @param Ghost to add.
     */
    public void addGhost(Ghost g)
    {
        ghosts.add(g);
    }
    
    /**
     * Whether or not there is a ghost at the coordinate.
     * @return True if there is a ghost there, false if there isn't.
     */
    public boolean hasGhostAt(int i, int j)
    {
        for (Ghost g : ghosts)
        {
            if ((i == g.getX()) && (j == g.getY()))
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
        System.out.print("\f"); //form feed "clears" the console (at least on Mac).
        print();
        System.out.print(COMMAND_REQUEST);
    }
    
    /**
     * Has pacman got caught by a ghost yet.
     * @return true if the pacman has got caught.
     */
    public boolean hasLost()
    {
        for (Ghost g : ghosts)
        {
            if (hasGhostAt(p.getX(), p.getY()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Has Pacman reached the exit yet.
     * @return true if Pacman has reached the exit.
     */
    public boolean hasWon()
    {
        // if all dots are gone. (all grid are true)
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                if (grid[i][j] == false)
                {
                    return false;
                }
            }
        }
        return true;          
    }
    
    /**
     * Returns a string representation of the grid: 
     * - put an "G" at the location of a Ghost
     * - put a "P" if Pacman is at a given coordinate; 
     * - print an "o" for an uneaten part.
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
                else if (hasGhostAt(i,j))
                {
                    //ghost has precedence over pacman
                    output = output + GHOST_STRING + H_SPACER_STRING;
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
    
    /**
     * Ouput a string representation of the grid to the console.
     */
    public void print()
    {
        System.out.println(toString());
    }
}
