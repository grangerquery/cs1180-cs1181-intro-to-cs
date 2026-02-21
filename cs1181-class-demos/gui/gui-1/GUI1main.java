import javax.swing.*;

public class GUI1main {
    public static void main(String[] args) {
        int clicks = 0;

        JFrame window = new JFrame("Hello world!");
        window.setSize(300, 300);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        YellowPanel myPanel = new YellowPanel();
        window.setContentPane(myPanel);

        // Simple text (labels)
        JLabel label1 = new JLabel("Clicks: " + clicks);
        JLabel label2 = new JLabel("Goodbye.");
        myPanel.add(label1);
        myPanel.add(label2);

        // Simple buttons
        JButton button1 = new JButton("Click me!");
        ButtonListener listener1 = new ButtonListener();
        button1.addActionListener(listener1);
        myPanel.add(button1);

        JButton button2 = new JButton("Click me too!");
        myPanel.add(button2);

        window.setVisible(true);
    }
}