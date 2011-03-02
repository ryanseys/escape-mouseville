import java.util.ArrayList;
import java.awt.*; // The Point class needs this.
/**
 * Write a description of class Maze here.
 * 
 * @author Ryan Seys 
 * @version 1.0
 */
public class Maze
{
    // instance variables - replace the example below with your own
    public static final int SIZE = 5;
    public boolean grid[][];
    public ArrayList<Point> walls;
    protected Player p;
    protected ArrayList<Monster> monsters;
    public static final int DEFAULT_PLAYER_X = 4;
    public static final int DEFAULT_PLAYER_Y = 2;
    public static final int DEFAULT_EXIT_X = 3;
    public static final int DEFAULT_EXIT_Y = 3;
    public static final String MOUSE_STRING = "M";
    public static final String EXIT_STRING = "X";
    public static final String ELEPHANT_STRING = "E";
    public static final String TRAP_STRING = "T";
    public static final String EMPTY_SPACE_STRING = ".";
    public static final String WALL_STRING = "W";
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
        walls = new ArrayList<Point>();
        Monster m1 = new Monster(this); //create a mouse
        monsters.add(m1); //add it to the list
        grid = new boolean[SIZE][SIZE];
        
        //adding walls for testing
        addWall(1,1);
        addWall(1,2);
        addWall(1,3);
        addWall(1,4);
        addWall(2,4);
        addWall(3,4);
        addWall(4,4);
    }

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
     * Returns a string representation of the grid.
     * @return A string representation of the grid.
    */
    public String toString()
    {
        String output = ""; //initialize
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
    
    public boolean hasWallAt(int x, int y)
    {
        for(Point w : walls) {
            if ((w.getX() == x) && (w.getY() == y))
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
    
    public ArrayList<Point> getWalls()
    {
        return walls;
    }
    
    public void addWall(int x, int y)
    {
        getWalls().add(new Point(x,y));
        grid[x][y] = true;
    }
    
    /**
     * Ouput a string representation of the grid to the console.
     */
    public void print()
    {
        System.out.println(toString());
    }
}
