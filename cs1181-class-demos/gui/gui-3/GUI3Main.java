import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI3Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Drawing window");
        JPanel content = new JPanel();
        window.setContentPane(content);
        content.setLayout(new BoxLayout(content, BoxLayout.PAGE_AXIS));

        Drawing drawingWindow = new Drawing();
        content.add(drawingWindow);

        window.setSize(500, 500);
        window.setLocation(750, 200);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
