
/**
 * A wall item cannot be passed.
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class Wall implements Item
{
    // instance variables - replace the example below with your own
    private static final String LETTER = "W";
    
    public Wall() {
    }

    /**
     * Returns the string representation of the object.
     **/
    public String getLetter() {
        return LETTER;
    }
}
