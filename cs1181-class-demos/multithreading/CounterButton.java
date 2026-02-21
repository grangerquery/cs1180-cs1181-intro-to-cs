import javax.swing.JButton;
import javax.swing.JPanel;

public class CounterButton extends JButton implements Runnable {
    public CounterButton(String title) {
        super(title);
        this.addActionListener(e -> {
            Thread newThread = new Thread(this);
            newThread.start();
        });
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}