import java.awt.event.*;
import javax.swing.*;

public class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.print("Button pressed: ");
        System.out.println(((JButton) e.getSource()).getText());
    }
}
