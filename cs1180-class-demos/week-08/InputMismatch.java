import java.util.*;

public class InputMismatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = 0;
        boolean valid = false;

        while (!valid) {
            try {
                num1 = sc.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("I said give me a whole number");
                sc.nextLine();
            } finally {
                System.out.println("In the finally block");
            }
        }
        System.out.println(num1);

        System.out.println("I'm at the end of main");

        sc.close();
    }
}