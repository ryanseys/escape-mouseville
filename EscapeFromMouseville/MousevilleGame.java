
/**
 * This class basically "runs" the game through its play() method.
 * 
 * @author Ryan Seys
 * @version 0.1
 */
public class MousevilleGame
{
    // instance variables
    protected Mouseville maze;
    protected Elephant p;

    /**
     * Creates and sets the maze, sets the elephant by obtaining it from the maze.
     */
    public MousevilleGame()
    {
        maze = new Mouseville();
        p = new Elephant(maze);
    }

    /**
     * Outputs the current state of the maze - 
     * Gets console input from the user to determine the elephant's next move.
     * (keys to move, "m" to drop a mousetrap, "q" to quit)
     * Until game is won or lost or the user quit.
     */
    public void play()
    {
        //play
    }
    
    /**
     * Launches the game by instantiating a new game and calling play() on it.
     */
    public static void main(String[] args)
    {
        MousevilleGame m = new MousevilleGame();
        m.play();
    }
}
