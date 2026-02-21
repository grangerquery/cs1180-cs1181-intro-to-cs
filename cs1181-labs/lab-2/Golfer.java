/**
 * Class Golfer - contains a single golfer's information
 * 
 * @author Brayden Granger
 * @since 01/25/2023
 */
public class Golfer implements Comparable<Golfer> {
    private String firstName; // Golfer's first name
    private String lastName; // Golfer's last name
    private int score; // Golfer's score so far this round
    private int thru; // Number of holes golfer has cleared so far this round

    /**
     * Create a new golfer
     * 
     * @param firstName New golfer's first name
     * @param lastName  New golfer's last name
     * @param score     New golfer's score this round
     * @param thru      Number of holes the new golfer has cleared this round
     */
    public Golfer(String firstName, String lastName, int score, int thru) {
        this.firstName = firstName;
        this.lastName = lastName;

        // Makes sure new golfer's score this round is 0 or less
        try {
            if (score <= 0) {
                this.score = score;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid score detected. Initializing to 0.");
            this.score = 0;
        }

        // Makes sure number of holes new golfer has cleared this round is 0 or more
        try {
            if (thru >= 0) {
                this.thru = thru;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid number of holes detected. Initializing to 0.");
            this.thru = 0;
        }
    }

    /**
     * Returns a golfer's first name
     * 
     * @return A string representing a golfer's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns a golfer's last name
     * 
     * @return A string representing a golfer's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns a golfer's score this round
     * 
     * @return An integer representing a golfer's score this round
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns the number of holes a golfer has cleared this round
     * 
     * @return An integer representing the of holes a golfer has cleared this round
     */
    public int getThru() {
        return thru;
    }

    /**
     * Prints a golfer's information to the terminal
     * 
     * @return A string representing a golfer's information in the form 'lastName,
     *         firstName: score through thru'
     */
    @Override
    public String toString() {
        return lastName + ", " + firstName + ": " + score + " through " + thru;
    }

    /**
     * Sorts an array list of golfers
     * 
     * Golfers are sorted first by score (lowest first), second by thru (highest
     * first), third by first name (lexicographically), and last by last name
     * (lexicographically).
     * 
     * @return -1, 0, 1 representing whether a given golfer should be sorted before,
     *         the same, or after a different golfer.
     */
    @Override
    public int compareTo(Golfer other) {
        if (score < other.score) {
            return -1;
        } else if (score > other.score) {
            return 1;
        } else if (thru > other.thru) {
            return -1;
        } else if (thru < other.thru) {
            return 1;
        } else if (firstName.compareToIgnoreCase(other.firstName) != 0) {
            return firstName.compareToIgnoreCase(other.firstName);
        } else if (lastName.compareToIgnoreCase(other.lastName) != 0) {
            return lastName.compareToIgnoreCase(other.lastName);
        } else {
            return 0;
        }
    }
}