import java.util.ArrayList;
import java.awt.*; // The Point class needs this.
/**
 * Maze is essentially a grid of booleans 
 * representing the terrain of "dots" a 
 * reference to the player, a bunch of monsters.
 * 
 * @author Ryan Seys 
 * @version 1.0
 */
public abstract class Maze
{
    // instance variables - replace the example below with your own
    public static final int SIZE = 5;
    public Item grid[][];
    protected Player p;
    protected ArrayList<Monster> monsters;
    public static final int DEFAULT_PLAYER_X = 4;
    public static final int DEFAULT_PLAYER_Y = 2;
    public static final int DEFAULT_EXIT_X = 3;
    public static final int DEFAULT_EXIT_Y = 3;
    public static final String EMPTY = "."; 
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
        p = new Player(DEFAULT_PLAYER_X, DEFAULT_PLAYER_Y, this);
        monsters = new ArrayList<Monster>();
        Monster m1 = new Monster(this); //create a mouse
        monsters.add(m1); //add it to the list
        grid = new Item[SIZE][SIZE];
        //adding walls for testing
//         addWall(1,1);
//         addWall(1,2);
//         addWall(1,3);
//         addWall(1,4);
//         addWall(2,4);
//         addWall(3,4);
//         addWall(4,4);
    }
    
        /**
     * @return true if the whole board has no dots left (player hit all dots)
     */
    public abstract boolean hasWon(); //checks to see if won.
    
    /**
     * "Resolves" the new state of the game.
     */
    public abstract void  resolve();
    
    /**
     * Returns the string associated with any object on a given space.
     */
    public abstract String gridNull(int x, int y);

    /**
     * Fetch and return the Player object.
     * @return A reference to the Player.
    */
    public Player getPlayer()
    {
        return p;
    }
    
    /**
     * All the monsters created.
     * @return The ArrayList of monsters
    */
    public ArrayList<Monster> getMonsters() 
    {
        return monsters;
    }
    
    /**
     * Add a monster to the list of monsters.
     * @param Monster to add.
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
            if (hasMonster(getPlayer().getX(), getPlayer().getY()))
            {
                return true;
            }
        }
        return false;
    }
    
        /**
     * Returns a string representation of the grid: 
     * - put an "G" at the location of a Ghost
     * - put a "P" if Pacman is at a given coordinate; 
     * - print an "D" for an uneaten dot.
     * - print a "." for an eaten dot.
     * @return A string representation of the grid.
     */
    public String toString() {
        String output = ""; //initialize
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                // Note: The order of the following IF statements controls precedence over which letter
                // is displayed when two objects overlap.
                output += gridNull(i, j);
                if(gridNull(i, j).equals("")) {
                    output += grid[i][j].getLetter();
                }
                output += H_SPACER_STRING;
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