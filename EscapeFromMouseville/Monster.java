
/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Creature
{

    /**
     * Constructor for objects of class Monster
     */
    public Monster(Maze m)
    {
        super(m);
    }

   public Monster(int x, int y, Maze m)
   {
       super(x, y, m);
   }
   
   /**
     * Move one step in the general direction of the elephant.
     */
    public void move()
    {
        // Four cases: Move left, right, up or down of Elephant.
        // quite possibly the laziest move algorithm ever.
        if (this.getY() > maze.getPlayer().getY()) //elephant is above
        { 
            y -= 1; //move up
        }
        else if (this.getY() < maze.getPlayer().getY()) //elephant is below
        {
            y += 1; //move down
        }
        else if (this.getX() < maze.getPlayer().getX()) //elephant on right
        {
            x += 1; //move right
        }
        else if (this.getX() > maze.getPlayer().getX()) //elephant on left
        {
            x -= 1; //move left
        }
        else
        {
            //ON TOP OF ELEPHANT! :O (this is handled elsewhere but functionality can be added here).
        }
    }
}
