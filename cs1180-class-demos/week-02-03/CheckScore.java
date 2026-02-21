import java.util.Scanner;

public class CheckScore {
    public static void main(String[] args) throws Exception {
        // input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, would you like to evaluate a score?");
        String userResponse = sc.nextLine();
        if (userResponse.equalsIgnoreCase("yes")) {

        }
        int gameScore = sc.nextInt();

        // set score ranges
        // Loser   - 0-499
        if (gameScore <= 499) {
            System.out.println("That is a LOSING score.");
        }
        // Average - 500-749
        else if (gameScore >= 500 && gameScore <= 749) {
            System.out.println("That is an AVERAGE score.");
        }
        // Winner  - 750-1000
        else if (gameScore >=750 && gameScore <= 1000) {
            System.out.println("That is a WINNING score.");
        }
        // Steve's score
        else {
            System.out.println("They must be Steve Harvey.");
        }

        sc.close();
    }
}