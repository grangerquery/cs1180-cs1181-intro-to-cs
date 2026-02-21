import java.util.Scanner;

public class BasicMenu {
    public static void main(String[] args) throws Exception {
        // calculator

        // user to choose: mult, exp, add, sub
        // user enters operation
        //      user to give a Letter.
        // Let user enter two numbers

        // initialize
        int x, y, result;
        char userChoice = 'a';
        Scanner sc = new Scanner(System.in);

        System.out.println("Which calc function: \n" + 
        "a. Addition\n" + 
        "b. Subtraction\n" + 
        "c. Multiplication\n" + 
        "d. Division");

        userChoice = sc.next().charAt(0);

        System.out.println("Provide two numbers (num1 num2): ");
        x = sc.nextInt();
        y = sc.nextInt();

        switch (userChoice) {
            case 'a':
                System.out.println("User selected add.");
                result = x + y;
                System.out.printf("%d and %d added together = %d", x, y, result);
                break;
            case 'b':
                System.out.println("User selected subtract.");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        // output a result of the operation

        sc.close();
    }
}