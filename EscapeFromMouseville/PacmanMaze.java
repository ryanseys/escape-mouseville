import java.util.ArrayList;
/**
 * Write a description of class PacmanMaze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacmanMaze
{
    // instance variables - replace the example below with your own
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
     * Fetch and return the elephant object.
     * @return A reference to the elephant.
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
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        // if all dots are gone. (all grid are true)
        return false;
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
                if (hasGhostAt(i,j)) {
                    output = output + GHOST_STRING + H_SPACER_STRING;
                }
                else if ((i == p.getX()) && (j == p.getY()))
                {
                    //elephant has precendence over traps.
                    output = output + PAC_STRING + H_SPACER_STRING; 
                }
                else if (grid[i][j] == false)
                {
                        //empty spot
                        output = output + DOT + H_SPACER_STRING;
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
