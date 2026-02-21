public class MyRunnable {
    public static void main(String[] args) {
        new Thread(() -> { // Lambda expression when no parameters are taken
            for (int i = 1; i < 27; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            for (char c = 'a'; c <= 'z'; c++) {
                System.out.println(c);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
