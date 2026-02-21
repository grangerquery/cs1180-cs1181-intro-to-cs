import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(perm("abc"));
    }

    /**
     * Permutations of a string
     */
    public static ArrayList<String> perm(String theString) {
        ArrayList<String> result = new ArrayList<>();
        if (theString.length() <= 1) {
            result.add(theString);
            return result;
        }

        for (int i = 0; i < theString.length(); i++) {
            String current = theString.substring(i, i + 1);
            String theRest = theString.substring(0, i) + theString.substring(i + 1);

            ArrayList<String> subPerms = perm(theRest);
            for (String s : subPerms) {
                result.add(current + s);
            }
        }
        return result;
    }
}
