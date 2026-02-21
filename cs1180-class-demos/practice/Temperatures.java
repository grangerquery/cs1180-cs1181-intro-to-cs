import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This program takes the number of days from user input and gets temperatures
 * for each morning, noon, and night. It then calculates and outputs each day
 * average, morning average, noon average, and noon average to the terminal.
 * 
 * @author Brayden Granger
 */
public class Temperatures {
    /**
     * Averages the numbers in an array
     * 
     * @param nums an array of integers
     * @return the average of the numbers in an array
     */
    public static int findAverage(int[] nums) {
        int sum = 0, numOfNums = 0;

        for (int num : nums) {
            sum += num; // Calculates sum of numbers in array
            numOfNums++;
        }

        int average = sum / numOfNums; // Calculates average of numbers in array

        return average;
    }

    /**
     * This program takes the number of days from user input and gets temperatures
     * for each morning, noon, and night. It then calculates and outputs each day
     * average, morning average, noon average, and noon average to the terminal.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numDays = 0;
        boolean isValid = false;

        System.out.print("How many days of data? ");

        // Loops until user enters number of days
        while (!isValid) {
            try {
                numDays = sc.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                System.out.print("How many days of data? ");
                sc.nextLine();
            }
        }

        int[] morning = new int[numDays];
        int[] noon = new int[numDays];
        int[] night = new int[numDays];
        int[] day = new int[numDays];

        int tempNum = 0, dayTotal = 0;

        // Loops through each day
        for (int i = 0; i < numDays; i++) {
            System.out.println("Day " + (i + 1));

            System.out.print("Enter morning temp: ");
            // Loops until user enters number (temperature)
            do {
                isValid = false;

                try {
                    tempNum = sc.nextInt(); // Assigns temperature to tempNum
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    System.out.print("Enter morning temp: ");
                    sc.nextLine();
                }
            } while (!isValid);

            morning[i] = tempNum; // Adds temperature to night[] at index i
            dayTotal += tempNum; // Adds temperature to total temperature

            System.out.print("Enter noon temp: ");
            // Loops until user enters number (temperature)
            do {
                isValid = false;

                try {
                    tempNum = sc.nextInt(); // Assigns temperature to tempNum
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    System.out.print("Enter noon temp: ");
                    sc.nextLine();
                }
            } while (!isValid);

            noon[i] = tempNum; // Adds temperature to night[] at index i
            dayTotal += tempNum; // Adds temperature to total temperature

            System.out.print("Enter night temp: ");
            do {
                isValid = false;

                try {
                    tempNum = sc.nextInt(); // Assigns temperature to tempNum
                    isValid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input.");
                    System.out.print("Enter night temp: ");
                    sc.nextLine();
                }
            } while (!isValid);

            night[i] = tempNum; // Adds temperature to night[] at index i
            dayTotal += tempNum; // Adds temperature to total temperature

            day[i] = dayTotal; // Adds total temperature for the day to day[] at index i
            dayTotal = 0; // Resets total temperature for the day
        }

        System.out.println("---Average Report---");

        // Loops through each day
        for (int i = 0; i < numDays; i++) {
            // Prints average temperature for each day
            System.out.println("Day " + (i + 1) + " average is: " + (day[i]) / 3);
        }

        // Prints average morning, noon, and night temperatures for all days
        System.out.println("Morning average for all days: " + findAverage(morning));
        System.out.println("Noon average for all days: " + findAverage(noon));
        System.out.println("Night average for all days: " + findAverage(night));

        sc.close();
    }
}