import java.util.ArrayList;
import java.util.Arrays;

public class Maximum {
    public static void main(String[] args) {
        System.out.println(max(new ArrayList<Integer>(Arrays.asList(7, 2, 9, 3, 8))));
    }

    /**
     * Maximum of an array list of integers using recursion
     */
    public static Integer max(ArrayList<Integer> list) {
        // Rule 1: Base case
        if (list.size() == 0) {
            return 0;
        }

        // Rule 2: Divide and conquer
        Integer first = list.remove(0);

        // Rule 3: Pray that it works
        Integer partialMax = max(list);

        // Rule 4: Put it together
        if (first < partialMax) {
            return partialMax;
        } else {
            return first;
        }
    }
}
