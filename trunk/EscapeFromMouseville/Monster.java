/**
 * A Monster is a creature that chases players!
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Monster extends Creature
{
   /**
   * Assign the maze, and give an initial position (0, 0)
   */
   public Monster(Maze m)
   {
       super(m);
   }

   /**
   * Assign the maze and set the coordinates to 
   * the ones supplied by the parameters.
   */
   public Monster(int x, int y, Maze m)
   {
       super(x, y, m);
   }
   
   /**
     * Move one step in the general direction of the player.
     */
    public void move()
    {
        // Four cases: Move left, right, up or down of Player.
        // quite possibly the laziest move algorithm ever.
        if (this.getY() > maze.getPlayer().getY()) //player is above
        { 
            if (canGoTo(x, y - 1))
            {
                y -= 1;
            }//move up
        }
        else if (this.getY() < maze.getPlayer().getY()) //player is below
        {
            if (canGoTo(x, y + 1))
            {
                y += 1;
            } //move down
        }
        else if (this.getX() < maze.getPlayer().getX()) //player on right
        { 
            if (canGoTo(x + 1, y))
            {
                x += 1;
            } //move right
        }
        else if (this.getX() > maze.getPlayer().getX()) //player on left
        {
            if (canGoTo(x - 1, y))
            {
                x -= 1;
            } //move left
        }
        else
        {
            //ON TOP OF PLAYER! :O (this is handled elsewhere but functionality can be added here).
        }
    }
}