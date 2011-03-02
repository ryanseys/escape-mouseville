

/**
 * The test class PacmanMazeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PacmanMazeTest extends junit.framework.TestCase
{
    /**
     * Default constructor for test class PacmanMazeTest
     */
    public PacmanMazeTest()
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

	public void testDots()
	{
		PacmanMaze pacmanMa1 = new PacmanMaze();
		Player player1 = pacmanMa1.getPlayer();
		assertEquals(false, pacmanMa1.hasDotAt(0, 1));
		pacmanMa1.eat(0, 1);
		assertEquals(true, pacmanMa1.hasDotAt(0, 1));
	}
}

