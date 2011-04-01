import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import java.awt.event.*;
/**
 * GUI for Pacman Game!
 * 
 * @author Ryan Seys
 * @version 1.0
 */
public class GraphicalPacmanGame extends Game implements ActionListener
{
    private JFrame gameFrame;
    private GameButton[][] buttons;
    private Maze maze;
    /**
     * Creates the GUI for the game.
     */
    public GraphicalPacmanGame(Maze m)
    {
        super(m);
        maze = m;
        GameButton button;
        buttons = new GameButton[m.SIZE][m.SIZE];
        gameFrame = new JFrame("Pacman Game");
        Container contentPane = gameFrame.getContentPane();
        contentPane.setLayout(new GridLayout(m.SIZE,m.SIZE));
        for(int j = 0; j < m.SIZE; j++) {
            for(int i = 0; i < m.SIZE; i++) {
                button = new GameButton(i, j);
                //Add the FRAME as the LISTENER to EACH button!
                //When the BUTTON is clicked, the LISTENER to that button instantiates
                //actionPerformed method below!
                button.addActionListener(this);
                buttons[i][j] = button;
                gameFrame.add(button);
            }
        }
        repaint();
        gameFrame.setSize(350,350);
        gameFrame.setVisible(true);
    }
    
    /**
     * This is what happens everytime a button is clicked.
     */
    public void actionPerformed(ActionEvent arg) {
        GameButton source = (GameButton) arg.getSource();
        if(maze.getPlayer().canGoTo((int) source.getCoord().getX(), (int) source.getCoord().getY())) {
            maze.getPlayer().goTo((int) source.getCoord().getX(), (int) source.getCoord().getY());
            maze.grid[(int) source.getCoord().getX()][(int) source.getCoord().getY()] = null;
            for (Monster m : maze.getMonsters())
            {
                m.move(); //comment this out if you want to test the game winnability.
            }
            repaint();
            if (maze.hasLost())
            {
                alert("YOU LOST!");
                System.exit(0);
            }
            else if (maze.hasWon())
            {
                alert("YOU WON!");
                System.exit(0);
            }
        }
    }
    
    /**
     * Remake the GUI interface for each click.
     */
    public void repaint() {
        for(int j = 0; j < maze.SIZE; j++)
        {
            for(int i = 0; i < maze.SIZE; i++)
            {
                buttons[i][j].setText(maze.gridNull(i,j));
                if(maze.gridNull(i, j).equals("")) {
                    buttons[i][j].setText(maze.grid[i][j].getLetter());
                }
            }
        }
    }
    
    /**
     * Show an alert to the user. (Windowed alert).
     */
    public void alert(String s) {
        JOptionPane.showMessageDialog(null,s);
    }
}
