public class Reverse {
    public static void main(String[] args) {
        System.out.println(reverse("Hello"));
    }

    /**
     * Reverse a string using recursion
     */
    public static String reverse(String theString) {
        // Rule 1: Base case
        if (theString.length() < 2) {
            return theString;
        }

        // Rule 2: Divide and conquer
        String firstChar = theString.substring(0, 1);

        // Rule 3: Pray that it works
        String theRest = reverse(theString.substring(1));

        // Rule 4: Put it together
        return theRest + firstChar;
    }
}
