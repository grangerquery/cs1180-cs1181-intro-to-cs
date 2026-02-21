import java.util.Scanner;

/* 
 * Name:     Brayden Granger
 * Title:    Practice Problem 4
 * Class:    CS1180L
 * Due Date: 29 September 2023
 */

public class InputTo100 {
    public static void main (String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double userNum = 0;
        double userTotal = 0;
        int numInputs = 0;

        // Ask user for input
        // Keep running total
        //  Stop program once total >= 100
        // Tell user how many numbers they entered before total met/exceeded 100

        while (userTotal <= 100) {
            System.out.print("Enter a number: ");
            userNum = sc.nextDouble();
            userTotal = userTotal + userNum;
            numInputs++; 
        }
        System.out.println("You entered " + (numInputs - 1) + " values before the total was greater than 100.");

        sc.close();
    }
}