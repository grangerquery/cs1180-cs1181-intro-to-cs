import java.util.LinkedList;
import java.util.List;

public class SIngleLinkedListMain {
    public static void main(String[] args) {
        SingleLinkedList<Integer> iList = new SingleLinkedList<>();
        iList.addLast(1);
        iList.addLast(2);
        iList.addLast(3);
        iList.addLast(4);
        iList.addLast(5);
        iList.addLast(6);

        for (Integer i : iList) {
            for (Integer j : iList) {
                System.out.println(i + ", " + j);
            }
        }

        // SingleLinkedList<String> myList = new SingleLinkedList<>();
        // myList.addLast("1");
        // myList.addLast("2");
        // myList.addLast("3");
        // myList.addLast("4");
        // myList.add(2, "10");
        // myList.add(5, "20");
        // System.out.println(myList);
    }
}
