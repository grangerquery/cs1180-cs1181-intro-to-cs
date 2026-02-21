import java.util.Scanner;

public class DoWhileLoops {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // while style

        char userLetter = 'y';
        while (userLetter == 'y') {
            System.out.println("Type in while loop (y OR n): ");
            userLetter = sc.next().charAt(0);
        }

        sc.nextLine();

        // do while style

        userLetter = 'n';
        do {
            System.out.println("Type in do while (y OR n): ");
            userLetter = sc.next().charAt(0);
        } while (userLetter == 'y');

        sc.close();
    }
}
