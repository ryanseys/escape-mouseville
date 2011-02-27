import java.util.ArrayList;
import java.awt.*; // The Point class needs this.
/**
 * Write a description of class Maze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Maze
{
    // instance variables - replace the example below with your own
    public static final int SIZE = 5;
    public boolean grid[][];
    protected Player p;
    protected ArrayList<Monster> monsters;
    public static final int DEFAULT_EXIT_X = 3;
    public static final int DEFAULT_EXIT_Y = 4;
    public static final String MOUSE_STRING = "M";
    public static final String EXIT_STRING = "X";
    public static final String ELEPHANT_STRING = "E";
    public static final String TRAP_STRING = "T";
    public static final String EMPTY_SPACE_STRING = ".";
    // horizontal spacer to make it look like a square
    public static final String H_SPACER_STRING = "   "; 
    // vertical spacer to make it look like a square
    public static final String V_SPACER_STRING = "\n\n"; 
    public static final String COMMAND_REQUEST = "Enter a command: ";

    /**
     * Constructor for objects of class Maze
     */
    public Maze()
    {
        p = new Player(this);
        monsters = new ArrayList<Monster>();
        Monster m1 = new Monster(this); //create a mouse
        monsters.add(m1); //add it to the list
        grid = new boolean[SIZE][SIZE];
    }

    /**
     * Fetch and return the elephant object.
     * @return A reference to the elephant.
    */
    public Player getPlayer()
    {
        return p;
    }
    
    /**
     * All the mice created.
     * @return The ArrayList of mice.
    */
    public ArrayList<Monster> getMonsters() 
    {
        return monsters;
    }
    
    /**
     * Add a mouse to the list of mice
     * @param Mouse to add.
    */
    public void addMonster(Monster m)
    {
        monsters.add(m);
    }
    
    /**
     * Whether or not there is a mouse at the coordinate.
     * @return True if there is a mouse there, false if there isn't.
    */
    public boolean hasMonster(int i, int j)
    {
        for (Monster m : monsters)
        {
            if ((i == m.getX()) && (j == m.getY()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return if the player and monster are in the same spot.
    */
    public boolean hasLost()
    {
        for (Monster m : monsters)
        {
            if (hasMonster(p.getX(), p.getY()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * @return true if the whole board has no dots left (player hit all dots)
     */
    public boolean hasWon() //checks to see if
    {
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            { 
                if (grid[i][j] == true) {
                    return false;
                }
            }
        }
        return true;        
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
//                 else if ((i == exit.getX()) && (j == exit.getY()))
//                 {
//                     //exit has precendence over elephant
//                     output = output + EXIT_STRING + H_SPACER_STRING; 
//                 }
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
     * Checks if a coordinate has a mousetrap on it.
     * @param  x   x-coordinate to check for a trap.
     * @param  y   y-coordinate to check for a trap.
     * @return true if there is a mousetrap at the indicated coordinate.
     */
    public boolean hasDotAt(int x, int y)
    {
        if(grid[x][y] == true)
        {
            return true;
        }
        else return false;
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
             if (hasDotAt(m.getX(), m.getY())) //mouse on mousetrap
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
     * Ouput a string representation of the grid to the console.
     */
    public void print()
    {
        System.out.println(toString());
    }
}
