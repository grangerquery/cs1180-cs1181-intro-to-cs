import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        System.out.println(sort(new ArrayList<Integer>(Arrays.asList(7, 2, 9, 3, 8))));
    }

    /**
     * Sorted array list
     */
    public static ArrayList<Integer> sort(ArrayList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        ArrayList<Integer> theRest = new ArrayList<>(list);
        Integer first = theRest.remove(0);

        ArrayList<Integer> result = sort(theRest);

        int position = 0;
        while (position < result.size() && result.get(position) < first) {
            position++;
        }
        result.add(position, first);
        return result;
    }
}
