import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    private JPanel eastPanel;

    public MyFrame() {
        super();
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        this.setContentPane(content);

        // 0px border at north, west, south, east
        content.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // North
        JMenuBar menuBar = new JMenuBar();
        JMenu colorMenu = new JMenu("Color");
        menuBar.add(colorMenu);

        ActionListener myMenuListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                switch (s) {
                    case "Red":
                        eastPanel.setBackground(Color.RED);
                        break;
                    case "Yellow":
                        eastPanel.setBackground(Color.YELLOW);
                        break;
                    case "Blue":
                        eastPanel.setBackground(Color.BLUE);
                        break;
                    default:
                        break;
                }
            }
        };

        JMenuItem colorItem = new JMenuItem("Red");
        colorMenu.add(colorItem);
        colorItem.addActionListener(myMenuListener);
        colorItem = new JMenuItem("Yellow");
        colorMenu.add(colorItem);
        colorItem.addActionListener(myMenuListener);
        colorItem = new JMenuItem("Blue");
        colorMenu.add(colorItem);
        colorItem.addActionListener(myMenuListener);

        content.add(menuBar, BorderLayout.NORTH);

        // East 1
        eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
        content.add(eastPanel, BorderLayout.EAST);

        JRadioButton radio1 = new JRadioButton("XOption 1", true);
        JRadioButton radio2 = new JRadioButton("XOption 2", false);
        JRadioButton radio3 = new JRadioButton("XOption 3", false);

        ItemListener radioListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(((JRadioButton) e.getSource()).getText());
                System.out.println(e.getStateChange());
            }
        };
        radio1.addItemListener(radioListener);
        radio2.addItemListener(radioListener);
        radio3.addItemListener(radioListener);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(radio1);
        group1.add(radio2);
        group1.add(radio3);

        eastPanel.add(radio1);
        eastPanel.add(radio2);
        eastPanel.add(radio3);

        // East 2
        String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        JList<String> dayList = new JList<String>(days);
        dayList.addListSelectionListener(e -> {
            System.out.println(dayList.getSelectedValue());
        });
        eastPanel.add(dayList);

        // South
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
        content.add(southPanel, BorderLayout.SOUTH);

        JCheckBox checkBox1 = new JCheckBox("Option 1");
        southPanel.add(checkBox1);
        checkBox1.addItemListener(e -> {
            System.out.println(e.getStateChange());
        });

        JCheckBox checkBox2 = new JCheckBox("Option 2");
        southPanel.add(checkBox2);
        checkBox2.addItemListener(e -> {
            System.out.println(e.getStateChange());
        });

        // West
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
        content.add(westPanel, BorderLayout.WEST);

        westPanel.add(new JButton("West1"));
        westPanel.add(new JButton("West2"));
        westPanel.add(new JButton("West3"));

        // Center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 3));
        content.add(centerPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 9; i++) {
            centerPanel.add(new JButton("Button" + i));
        }
    }
}