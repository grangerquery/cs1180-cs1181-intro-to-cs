import java.util.Scanner;

/*
 *  Student: Brayden Granger
 *  Class: CS1180L
 *  Due date: 6 October 2023
 *  Description: This program prompts the user for the number of columns an X will have then draws
 *      it using asterisks (*). If the user provides a number that is even or less than five, the
 *      program displays an error message.
 */

public class PrintX {
    public static void main(String[] args) throws Exception {
        // FOR REFERENCE:
        // xSize = 5

        // 4 * *
        // 3 * *
        // 2 *
        // 1 * *
        // 0 * *
        // 0 1 2 3 4

        // i == j: (0, 0), (1, 1), (2, 2), (3, 3), (4, 4)
        // i + j == xSize - 1: (0, 4), (1, 3), (3, 1), (4, 0); E.g. 0 + 4 = 5 - 1

        Scanner sc = new Scanner(System.in);

        // Prompt the user for xSize
        System.out.println("How many columns and rows will the X have?");
        int xSize = sc.nextInt();

        // Draw an X whose lines are made of xSize asterisks (*)
        if (xSize % 2 != 0 && xSize > 3) { // Checks if xSize is both odd and greater than 3
            for (int i = 0; i < xSize; i++) { // xSize rows
                for (int j = 0; j < xSize; j++) { // xSize columns
                    if (i == j || i + j == xSize - 1) { // If (SEE REFERENCE AT TOP), prints "*"
                        System.out.print("*");
                    } else {
                        System.out.print(" "); // Otherwise, prints a space
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Error: Number must be an odd number greater than 3.");
        }
        sc.close();
    }
}