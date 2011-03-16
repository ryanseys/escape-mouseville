import java.util.Random;
/**
 * Write a description of class Digger here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Digger extends Maze
{
    // instance variables - replace the example below with your own
    public static final String MONSTER_STRING = "M";
    public static final String DIGGER_STRING = "P";
    private int points;
    /**
     * Constructor for objects of class Digger
     */
    public Digger() 
    {
        for(int j = 0; j < SIZE; j++)
        {
            for(int i = 0; i < SIZE; i++)
            {
                grid[i][j] = null;
            }
        }
        
        grid[2][3] = new Hole();
        grid[4][1] = new Hole();
        grid[1][0] = new Hole();
        grid[3][4] = new Hole();
        monsters.remove(0);
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
     * Has the elephant reached the exit yet.
     * @return true if the elephant has reached the exit.
     */
    public boolean hasWon()
    {
        return false;
    }

    public String gridNull(int i, int j) {
        if (hasMonster(i,j)) {
            return MONSTER_STRING;
        }
        else if ((i == p.getX()) && (j == p.getY())) {
            return DIGGER_STRING;  //elephant has precendence over traps.
        }
        else if(grid[i][j] == null) {
            return EMPTY;
        }
        else return ""; //empty space
    }
}