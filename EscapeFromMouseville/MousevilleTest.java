/**
 * To Test Mouseville Class
 *
 * @author  Ryan Seys
 * @version 1.0
 */
public class MousevilleTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class MousevilleTest
     */
    public MousevilleTest()
    {
    }
    
	public void testWallTest()
	{
		Mouseville mousevil1 = new Mouseville();
		Player player1 = mousevil1.getPlayer();
		assertEquals(mousevil1.getPlayer(), player1);
		player1.moveRight();
		player1.moveDown();
		assertEquals(0, player1.getY());
	}

	public void testMousetraps()
	{
	    //make a mousetrap and make the monster walk into it.
		Mouseville mousevil1 = new Mouseville();
		mousevil1.setMousetrap(0, 1);
		Player player1 = mousevil1.getPlayer();
		player1.moveRight();
		player1.moveRight();
		java.util.ArrayList<Monster> arrayLis1 = mousevil1.getMonsters();
		Monster monster1 = (Monster)arrayLis1.get(0);
		monster1.move();
		assertEquals(false, mousevil1.hasMonster(0, 1));
	}
}


