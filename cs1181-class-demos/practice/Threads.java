import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program uses threads to determine the count of prime numbers between 1
 * and a maximum value, as well as the program's runtime. The user will be
 * prompted to provide the number of threads and the maximum value.
 * 
 * Time at 1 thread(s), n = 10,000,000: ~860 milliseconds
 * Time at 2 thread(s), n = 10,000,000: ~550 milliseconds
 * Time at 3 thread(s), n = 10,000,000: ~390 milliseconds
 * Time at 4 thread(s), n = 10,000,000: ~315 milliseconds
 * 
 * @author Brayden Granger
 * @since 04/02/2024
 */
public class Driver {
    public static void main(String[] args) {
        // Initialization
        Scanner sc = new Scanner(System.in);
        int numThreads = 0, maxNum = 0, prev = 1, totalPrime = 0;

        // Validates that user input is acceptable
        while (true) {
            try {
                System.out.print("Number of threads: ");
                numThreads = sc.nextInt();
                System.out.print("Maximum number to check: ");
                maxNum = sc.nextInt();
                if (numThreads <= maxNum) {
                    break;
                } else {
                    System.out.println("Number of threads cannot exceed maximum value.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.next();
            }
        }
        sc.close();

        // Creation of + running through threads
        long start = System.nanoTime();
        ArrayList<PrimeThread> threads = new ArrayList<>();
        for (int i = 1; i <= numThreads; i++) {
            PrimeThread myThread = new PrimeThread(prev, (int) Math.floor(maxNum / numThreads) * i);
            prev = myThread.getEnd();
            threads.add(myThread);
            myThread.start();
        }

        // Prime tallying
        for (PrimeThread thread : threads) {
            try {
                thread.join();
                totalPrime += thread.getPrime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Final output
        System.out.println("Prime numbers between 1 and " + maxNum + ": " + totalPrime);
        System.out.println("Total time: " + (System.nanoTime() - start) / 1000000 + " milliseconds");
    }
}