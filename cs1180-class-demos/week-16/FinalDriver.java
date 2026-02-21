import java.util.ArrayList;
import java.util.Scanner;

/**
 * The driver class
 */
public class FinalDriver {

    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book TTBP = new Book("The Three-Body Problem", "Cixin Liu", "0765377063");
        Book UA = new Book("Unlikely Animals", "Annie Hartnett", "059316024X");
        Book LJTEW = new Book("Learn Java the Easy Way", "Bryson Payne", "1593278055");

        ArrayList<Book> library = new ArrayList<Book>();
        library.add(TTBP);
        library.add(UA);
        library.add(LJTEW);

        // Prints library
        System.out.println("---- LIBRARY STATUS ----");
        for (Book book : library) {
            System.out.println(book);
        }

        // Takes user input forever
        while (true) {
            System.out.println("Book title to lookup: ");
            String userInput = sc.nextLine();

            for (Book book : library) {
                if (userInput.equalsIgnoreCase(book.getTitle())) {
                    System.out.println(book);
                    if (book.getAvailability()) { // Available
                        System.out.println("Checkout book? (y / n)");
                        userInput = sc.nextLine();

                        if (userInput.equalsIgnoreCase("y")) {
                            book.checkout();
                        }
                    } else { // Unavailable
                        System.out.println("Checkin book? (y / n)");
                        userInput = sc.nextLine();

                        if (userInput.equalsIgnoreCase("y")) {
                            book.checkin();
                            book.setCondition(book.getCondition() - 1);

                            if (book.getCondition() < 2) { // Removes book if condition < 2
                                library.remove(book);
                            }
                        }
                    }
                    System.out.println(book);
                }
            }
        }
    }
}
