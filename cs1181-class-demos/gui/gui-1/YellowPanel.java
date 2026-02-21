import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class YellowPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}