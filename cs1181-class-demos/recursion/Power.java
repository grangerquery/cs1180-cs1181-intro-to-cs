public class Power {
    public static void main(String[] args) {
        System.out.println(power(3, 5));
    }

    /**
     * Value and exponent
     */
    public static int power(int val, int exp) {
        if (exp == 0) {
            return 1;
        }
        return val * power(val, exp - 1);
    }
}