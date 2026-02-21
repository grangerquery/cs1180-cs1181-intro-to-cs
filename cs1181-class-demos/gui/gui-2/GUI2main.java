import javax.swing.JFrame;

public class GUI2main {
    public static void main(String[] args) {
        MyFrame window = new MyFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 500);
        window.setLocation(800, 250);
        window.setVisible(true);
    }
}