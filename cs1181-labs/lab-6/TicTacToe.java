import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Class TicTacToe - Holds all the information of the game of tic-tac-toe.
 * 
 * @author Brayden Granger
 * @since 02/20/2024
 */
public class TicTacToe extends JFrame {
    private int clicks = 0;
    JLabel whoseTurn = new JLabel("Player one's turn");

    /**
     * A constructor for the game of tic-tac-toe.
     */
    public TicTacToe() {
        // Initialization and adding to content pane
        super();
        setTitle("Tic Tac Toe");
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(4, 3));
        setContentPane(content);

        // Creating array list of buttons and adding to content pane
        ArrayList<JButton> buttons = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            JButton newButton = new JButton("");
            buttons.add(newButton);
            this.add(newButton);
        }
        content.add(whoseTurn);

        for (JButton button : buttons) {
            button.addActionListener(e -> {
                clicks++;
                // If the number of clicks is odd, check whether the button has been clicked already
                if (clicks % 2 == 1) {
                    if (button.getText().equals("X") || button.getText().equals("O")) {
                        clicks--;
                    } else {
                        button.setText("X"); // Player one = X
                        whoseTurn.setText("Player two's turn");
                    }
                // If the number of checks is even, check whether the button has been clicked already
                } else {
                    if (button.getText().equals("X") || button.getText().equals("O")) {
                        clicks--;
                    } else {
                        button.setText("O"); // Player two = O
                        whoseTurn.setText("Player one's turn");
                    }
                }
                if (clicks == 9) { // Once all buttons have been clicked
                    whoseTurn.setText("Game over");
                }
            });
        }
    }
}
