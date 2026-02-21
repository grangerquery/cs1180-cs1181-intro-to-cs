import java.util.Scanner;

public class TimesTable {
    /**
     * This method prints a times table of length and width n.
     * 
     * @param n is the length and width of the times table provided by the user
     */
    public static void printTable(int n) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * This method determines whether n is between 0 and 50 or not.
     * 
     * @param n is the length and width of the times table provided by the user
     * @return true if n is between 0 and 50, otherwise false
     */
    public static Boolean verifyNum(int n) {
        if (n >= 0 && n <= 50) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This program prompts the user for a value of n, then prints a times table of
     * length and width n if n is between 0 and 50. If n is not between 0 and 50,
     * the program prints an error message and ends.
     * 
     * @author Brayden Granger
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the value of n? ");
        int n = sc.nextInt();

        if (verifyNum(n) == true) {
            printTable(n);
        } else {
            System.out.println("Error: n must be between 0 and 50.");
        }

        sc.close();
    }
}