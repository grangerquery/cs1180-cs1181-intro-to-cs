import java.util.ArrayList;
import java.util.Collections;

/**
 * Class Driver - the driver class
 * 
 * Prints an unsorted list of three golfers to the terminal, sorts them based on
 * their fields, then prints the sorted list to the terminal.
 * 
 * @author Brayden Granger
 * @since 1/25/2023
 */
public class Lab02Main {

    /**
     * Creates three golfer objects and adds them to an array list
     * 
     * @return An array list of golfer objects
     */
    public static ArrayList<Golfer> createGolferList() {
        Golfer a = new Golfer("Brayden", "Granger", -21, 17);
        Golfer b = new Golfer("Brayden", "Culp", -21, 17);
        Golfer c = new Golfer("Brayden", "Glass", -21, 17);

        ArrayList<Golfer> golfers = new ArrayList<Golfer>();
        golfers.add(a);
        golfers.add(b);
        golfers.add(c);

        return golfers;
    }

    /**
     * Prints golfer array list info to the terminal
     * 
     * @param golfers An array list of golfers
     */
    public static void printGolferList(ArrayList<Golfer> golfers) {
        for (Golfer golfer : golfers) {
            System.out.println(golfer.toString());
        }
    }
    public static void main(String[] args) {
        ArrayList<Golfer> golfers = createGolferList();
        printGolferList(golfers);

        System.out.println();

        Collections.sort(golfers);
        printGolferList(golfers);
    }
}