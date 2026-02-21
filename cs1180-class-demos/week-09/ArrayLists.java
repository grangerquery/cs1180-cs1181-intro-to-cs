import java.util.ArrayList;
import java.util.Scanner;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());
        nums.add(sc.nextInt());

        System.out.println("Contents of my Arraylist: ");
        for (Integer num : nums) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}