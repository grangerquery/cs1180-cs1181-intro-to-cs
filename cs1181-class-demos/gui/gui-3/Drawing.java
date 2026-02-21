import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Drawing extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawOval(50, 50, 75, 75);
        g.drawRect(getWidth() / 2, getHeight() / 2, 50, 50);
    }
}
