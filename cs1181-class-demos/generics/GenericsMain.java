import java.util.ArrayList;
import java.util.Arrays;

public class GenericsMain {
    public static void main(String[] args) {
        printMe("Hello");
        printMe(7.2);
        printMe(5);
        printMe(true);

        System.out.println();

        Integer intSmallest = min3(12, 7, 22);
        Double doubleSmallest = min3(22.5, 33.7, 7.2);
        // Cannot mix data types
        // Float mixedSmallest = min3(7, 9, 22.9);
        System.out.println(intSmallest);
        System.out.println(doubleSmallest);

        System.out.println();

        Integer values[] = {1, 2, 3, 4, 5};
        printArray(values);
        String strings[] = {"One", "Two", "Three"};
        printArray(strings);

        System.out.println();

        ArrayList<Integer> myList = new ArrayList<>(Arrays.asList(1, 5, 7, 9));
        System.out.println(removeTwo(myList));
        System.out.println(myList);
    }

    public static <T> void printMe(T item) {
        System.out.println("Item to print is: " + item);
    }

    public static <T extends Comparable<T>> T min3(T first, T second, T third) {
        T minval = first;
        if (minval.compareTo(second) > 0) {
            minval = second;
        }
        if (minval.compareTo(third) > 0) {
            minval = third;
        }
        return minval;
    }

    public static <E> void printArray(E theArray[]) {
        System.out.print("[");
        for (int i = 0; i < theArray.length; i++) {
            System.out.print(theArray[i]);
            if (i < theArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static <E> ArrayList<E> removeTwo(ArrayList<E> theList) {
        ArrayList<E> newList = new ArrayList<>();
        if (theList.size() > 1) {
            newList.add(theList.remove(0));
        }
        if (theList.size() > 1) {
            newList.add(theList.remove(0));
        }
        return newList;
    }
}
