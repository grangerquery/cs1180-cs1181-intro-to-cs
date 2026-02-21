/**
 * This program uses a recursive algorithm to check if a string is a nesting of
 * zero or more pairs of parenthesis
 * 
 * @author Brayden Granger
 * @since 03/26/2024
 */
public class Matching {
    public static void main(String[] args) {
        System.out.println(nestParen("")); // True - 0 pairs
        System.out.println(nestParen(")(")); // False - invalid
        System.out.println(nestParen("(((x)))")); // False - invalid
        System.out.println(nestParen("(())")); // True - 2 pairs
        System.out.println(nestParen("((()))")); // True - 3 pairs
        System.out.println(nestParen("((())))")); // False - unclosed parenthesis
        System.out.println(nestParen("()()()")); // False - not nested
    }

    /**
     * Checks if a given string is a nesting of zero or more pairs of parenthesis
     * using a recursive algorithm
     * 
     * @param n Any string
     * @return Whether the string is a nesting of zero or more pairs of parenthesis
     */
    public static boolean nestParen(String n) {
        // Empty string - true
        if (n.length() == 0) {
            return true;
        }
        // Length is odd - false
        if (n.length() % 2 != 0) {
            return false;
        }
        // First + last is not a pair of parenthesis - false
        if (!(n.substring(0, 1) + n.substring(n.length() - 1)).equals("()")) {
            return false;
        }
        // First + last is a pair of parenthesis - true, check the rest
        else {
            return true && nestParen(n.substring(1, n.length() - 1));
        }
    }
}