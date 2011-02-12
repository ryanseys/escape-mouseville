import java.util.Scanner;
/**
 * This class basically "runs" the game through its play() method.
 * 
 * @author Ryan Seys 
 * @version 1.0
 */
public class PacmanGame
{
    // instance variables
    protected PacmanMaze maze;
    protected Pacman p;

    /**
     * Constructor for objects of class PacmanGame
     */
    public PacmanGame()
    {
        // initialise instance variables
        maze = new PacmanMaze();
        p = new Pacman(maze);
    }

    /**
     * Outputs the current state of the maze - 
     * Gets console input from the user to determine pacman's next move.
     * (keys to move, "q" to quit)
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
            //move all the ghosts
            for (Ghost g : maze.getGhosts())
            {
                g.move();
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
}
