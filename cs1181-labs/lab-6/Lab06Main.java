import javax.swing.*;

/**
 * This program is an interactive game of tic-tac-toe using GUI elements. It is
 * designed to be played with two people. Once all nine buttons have been
 * clicked, the game is over.
 * 
 * @author Brayden Granger
 * @since 02/20/2024
 */
public class Lab06Main {
    public static void main(String[] args) {
        TicTacToe window = new TicTacToe();
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
