public class ForLoopDemo {
    public static void main(String[] args) throws Exception {
        int i = 0;

        for (i = 0; i <=10; i++) {
            System.out.print(i + " "); //Print 0-10
        }
        System.out.println();

        for (i = 0; i <= 100; i += 5) {
            System.out.print(i + " "); //Print every 5th number from 0-100
        }
        System.out.println();

        for (i = 11; i <=22; i++) {
            System.out.print(i + " "); //Print 11-22
        }
        System.out.println();

        for (i = 10; i >= 0; i--) {
            System.out.print(i + " "); //Print 10-0
        }
        System.out.println();
    }
}