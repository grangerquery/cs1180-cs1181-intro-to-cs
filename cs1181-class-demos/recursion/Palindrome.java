public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palChecker("abcddcba"));
    }

    /**
     * Palindrome checker
     */
    public static boolean palChecker(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (!s.substring(0, 1).equals(s.substring(s.length() - 1))) {
            return false;
        }
        return true && palChecker(s.substring(1, s.length() - 1));
    }
}
