import java.util.ArrayList;
import java.util.Collections;

/**
 * This program initializes a set of athletes and sorts them in two ways: (1)
 * alphabetically by sport then by name, (2) alphabetically by sport then by
 * ranking
 * 
 * @author Brayden Granger
 * @since 03/05/2024
 */
public class AthleteMain {
    public static void main(String[] args) {
        Athlete a1 = new Athlete("John Doe", "baseball", 3);
        Athlete a2 = new Athlete("Sam Johnson", "football", 2);
        Athlete a3 = new Athlete("Kevin Smith", "baseball", 1);
        Athlete a4 = new Athlete("Sally Johnson", "swimming", 3);
        Athlete a5 = new Athlete("James Smith", "swimming", 4);
        Athlete a6 = new Athlete("Meagan Kelly", "swimming", 1);

        ArrayList<Athlete> athletes = new ArrayList<>();
        athletes.add(a1);
        athletes.add(a2);
        athletes.add(a3);
        athletes.add(a4);
        athletes.add(a5);
        athletes.add(a6);

        System.out.println("Unsorted");
        for (Athlete a : athletes) {
            System.out.println(a);
        }

        System.out.println("\nSorted by sport and then name");
        Collections.sort(athletes);
        for (Athlete a : athletes) {
            System.out.println(a);
        }

        System.out.println("\nSorted by sport and then ranking");
        Collections.sort(athletes, new RankingComparator());
        for (Athlete a : athletes) {
            System.out.println(a);
        }
    }
}
