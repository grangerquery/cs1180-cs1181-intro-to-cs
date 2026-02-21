import java.util.ArrayList;
import java.util.Arrays;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(new ArrayList<Integer>(Arrays.asList(4, 9))));
    }

    /**
     * Sum an array list of integers using recursion
     */
    public static Integer sum(ArrayList<Integer> list) {
        // Rule 1: Base case
        if (list.size() == 0) {
            return 0;
        }

        // Rule 2: Divide and conquer
        Integer first = list.remove(0);

        // Rule 3: Pray that it works
        Integer partialSum = sum(list);

        // Rule 4: Put it together
        return first + partialSum;
    }
}
