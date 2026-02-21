import java.util.ArrayList;
import java.util.Arrays;

public class Minimum {
    public static void main(String[] args) {
        System.out.println(min(new ArrayList<Integer>(Arrays.asList(7, 2, 9, 3, 8))));
    }

    /**
     * Minimum of array list
     */
    public static Integer min(ArrayList<Integer> list) {
        if (list.size() == 1) {
            return list.remove(0);
        }

        int halfWay = list.size() / 2;
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (i < halfWay) {
                firstHalf.add(list.get(i));
            } else {
                secondHalf.add(list.get(i));
            }
        }

        Integer minFirstHalf = min(firstHalf);
        Integer minSecondHalf = min(secondHalf);

        if (minFirstHalf < minSecondHalf) {
            return minFirstHalf;
        } else {
            return minSecondHalf;
        }
    }
}
