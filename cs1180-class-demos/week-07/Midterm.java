import java.util.Scanner;

public class Midterm {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int userNum, positiveSum = 0, negativeSum = 0;
        double numPositive = 0, numNegative = 0;

        do {
            System.out.print("Enter an integer (-1 to quit): ");
            userNum = sc.nextInt();
            sc.nextLine();

            // Positive, ignores 42
            if (userNum >= 0 && userNum != 42) {
                positiveSum += userNum;
                numPositive++;
            }
            // Negative, ignores -42 and -1
            else if (userNum < 0 && userNum != -42 && userNum != -1) {
                negativeSum += userNum;
                numNegative++;
            }
        } while (userNum != -1);

        System.out.println();
        System.out.println("Sum of positive integers: " + positiveSum);
        System.out.println("Sum of negative integers: " + negativeSum);
        System.out.printf("Average of positive integers: %.2f\n", ((double) positiveSum / numPositive));
        System.out.printf("Average of negative integers: %.2f", ((double) negativeSum / numNegative));

        sc.close();
    }
}
