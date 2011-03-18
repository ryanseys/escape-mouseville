import java.util.Scanner;
/**
 * This class basically "runs" the game through its play() method.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Game
{
    private Maze maze;

    /**
     * Constructor for objects of class Game
     */
    public Game(Maze m)
    {
        maze = m;
    }

    /**
     * Outputs the current state of the maze - 
     * Gets console input from the user to determine the elephant's next move.
     * (keys to move, "m" to drop a mousetrap, "q" to quit)
     * Until game is won or lost or the user quit.
     */
    public void play()
    {
        char command;
        boolean done = false;
        maze.resolve();
        while(!done)
        {
            Scanner s = new Scanner(System.in);
            try {
                command = s.nextLine().charAt(0);
            }
            catch (StringIndexOutOfBoundsException e) {
                command = '*';
            }
            maze.p.processCommand(command);
            //move all the mice.
            maze.resolve();
            for (Monster m : maze.getMonsters())
            {
                m.move(); //comment this out if you want to test the game winnability.
            }
            maze.resolve();
            if (maze.hasLost())
            {
                System.out.println("YOU LOST!");
                done = true;
            }
            else if (maze.hasWon())
            {
                System.out.println("YOU WON!");
                done = true;
            }
        }
    }
    
    /**
     * Launches the game by instantiating a new game and calling play() on it.
     */
    public static void main(String[] args)
    {
        Digger m = new Digger();
        Game g = new Game(m);
        g.play();
    }
}