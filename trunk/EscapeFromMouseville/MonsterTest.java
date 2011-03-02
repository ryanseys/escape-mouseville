

/**
 * The test class MonsterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MonsterTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class MonsterTest
     */
    public MonsterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    protected void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    protected void tearDown()
    {
    }

	public void testMonsterWin()
	{
		Mouseville mousevil1 = new Mouseville();
		Player player1 = mousevil1.getPlayer();
		player1.moveRight();
		player1.moveRight();
		assertEquals(true, mousevil1.hasMonster(0, 0));
		java.util.ArrayList<Monster> arrayLis1 = mousevil1.getMonsters();
		Monster monster1 = (Monster)arrayLis1.get(0);
		monster1.move();
		monster1.move();
		assertEquals(true, mousevil1.hasLost());
	}
}

