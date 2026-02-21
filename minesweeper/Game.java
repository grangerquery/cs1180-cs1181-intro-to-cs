import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * The driver class for the game of Minesweeper
 * 
 * @author Brayden Granger
 * @since 03/07/2024
 */
public class Game {
    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(800, 600);
        game.setLocation(100, 100);
        game.setResizable(false);
        game.setIconImage(new ImageIcon("src\\Icons\\minesweeper.png").getImage());
        game.setVisible(true);
        game.displayHelp();
    }
}