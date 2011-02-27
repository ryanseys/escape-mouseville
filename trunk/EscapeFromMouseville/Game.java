import java.util.Scanner;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    // instance variables - replace the example below with your own
    private Maze maze;

    /**
     * Constructor for objects of class Game
     */
    public Game()
    {
        maze = new Maze();
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
            command = s.nextLine().charAt(0);
            maze.p.processCommand(command);
            //move all the mice.
            for (Monster m : maze.getMonsters())
            {
                m.move();
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
        Game g = new Game();
        g.play();
    }
}
