import javax.swing.*;
import java.awt.*;

public class TemperatureConverter extends JFrame {
    public TemperatureConverter() {
        // Building initial frame
        super();
        setTitle("Temperature Converter");

        // Creating content panel and adding to panel
        JPanel content = new JPanel();
        content.setLayout(new GridLayout(3, 2));
        content.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setContentPane(content);

        // Initializing labels and text fields
        JLabel fahrenheitText = new JLabel("Fahrenheit");
        JTextField fahrenheitIn = new JTextField();
        JLabel celsiusText = new JLabel("Celsius");
        JTextField celsiusIn = new JTextField();
        JLabel errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);

        // Adding labels and text fields to content pane
        content.add(fahrenheitText);
        content.add(fahrenheitIn);
        content.add(celsiusText);
        content.add(celsiusIn);

        // Creating and adding button + error label to content pane
        JButton converter = new JButton("Convert");
        content.add(converter);
        content.add(errorLabel);

        // Working on button functionality
        converter.addActionListener(e -> {
            if (!fahrenheitIn.getText().equals("")) { // Fahrenheit to celsius
                try {
                    errorLabel.setText("");
                    double f = Double.parseDouble(fahrenheitIn.getText());
                    double c = (f - 32) * (5.0 / 9.0);
                    celsiusIn.setText(String.valueOf((c)));
                } catch (Exception er) {
                    errorLabel.setText("ERROR Invalid");
                    celsiusIn.setText("");
                    fahrenheitIn.setText("");
                    revalidate();
                }
            } else if (!celsiusIn.getText().equals("")) { // Celsius to fahrenheit
                try {
                    errorLabel.setText("");
                    double c = Double.parseDouble(celsiusIn.getText());
                    double f = (c * (9.0 / 5.0)) + 32;
                    fahrenheitIn.setText(String.valueOf(f));
                } catch (Exception er) {
                    errorLabel.setText("ERROR Invalid");
                    celsiusIn.setText("");
                    fahrenheitIn.setText("");
                    revalidate();
                }
            } else { // Both empty
                errorLabel.setText("ERROR Empty");
            }
        });
    }
}