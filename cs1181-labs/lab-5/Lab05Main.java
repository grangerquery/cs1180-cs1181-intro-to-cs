import javax.swing.*;

public class Lab05Main {
    public static void main(String[] args) {
        TemperatureConverter window = new TemperatureConverter();
        window.setSize(325, 150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}