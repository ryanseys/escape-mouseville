import javax.swing.JButton;
import java.awt.Point;
/**
 * GameButton is a button item on the GUI. 
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class GameButton extends JButton
{
    private Point coordinates; //has x and y coord

    /**
     * Constructor for objects of class GameButton
     */
    public GameButton(int x, int y)
    {
        super();
        coordinates = new Point();
        coordinates.setLocation(x, y);
    }

    /**
     * @return     coordinate of the button
     */
    public Point getCoord()
    {
        return coordinates;
    }
}
