public class Factorial {
    public static void main(String[] args) {
        System.out.println(fac(5));
    }

    /**
     * Factorial of an integer
     */
    public static int fac(int value) {
        // Base case
        if (value == 0) {
            return 1;
        }
        // Positive value
        else if (value > 0) {
            return value * fac(value - 1);
        }
        // Negative value
        else {
            return value * fac(value + 1);
        }
    }
}
