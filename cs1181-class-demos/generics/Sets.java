import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(7);
        s1.add(5);
        s1.add(7); // Ignored - cannot have duplicates
        s1.add(3);

        Set<Integer> s2;

        // Set intersection
        s2 = new HashSet<>(Arrays.asList(7, 5, 12, 9));
        s2.retainAll(s1);
        System.out.println(s2);

        // Set union
        s2 = new HashSet<>(Arrays.asList(7, 5, 12, 9));
        s2.addAll(s1);
        System.out.println(s2);
    }
}
