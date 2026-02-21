/**
 * A thread which determines the number of prime numbers between a given start
 * and end value
 * 
 * @author Brayden Granger
 * @since 04/02/2024
 */
public class PrimeThread extends Thread {
    private int start; // The starting number (inclusive)
    private int end; // The ending number (exclusive)
    private int numPrime; // The number of prime values

    /**
     * A PrimeThread constructor that takes a start and end value as parameters
     * 
     * @param start The starting value
     * @param end   The ending value
     */
    public PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Gets the starting value
     * 
     * @return The starting value
     */
    public int getStart() {
        return start;
    }

    /**
     * Gets the ending value
     * 
     * @return The ending value
     */
    public int getEnd() {
        return end;
    }

    /**
     * Returns the number of prime values
     * 
     * @return The number of prime values
     */
    public int getPrime() {
        return numPrime;
    }

    /**
     * Returns whether a given integer is prime
     * 
     * @param n The integer
     * @return Whether the integer is prime
     */
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Runs the thread
     */
    @Override
    public void run() {
        for (int i = getStart(); i < getEnd(); i++) {
            if (isPrime(i)) {
                numPrime++;
            }
        }
    }
}