/**
 * The driver class for player which controls the game
 * 
 * @author Brayden Granger
 */
public class PlayerDriver {

    /**
     * The main method
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Sets up player objects
        Player user = new Player("One Punch Man", 20);
        Player alien = new Player("Alien", 5);

        do { // Executes until user or alien is dead
            System.out.println(user.toString() + "\t" + alien.toString());
            user.dealDamage(alien);
            alien.dealDamage(user);
        } while (user.getHealth() > 0 && alien.getHealth() > 0);

        // Prints winner to terminal
        if (user.getHealth() > 0) {
            System.out.println("Winner is " + user.toString());
        } else {
            System.out.println("Winner is " + alien.toString());
        }
    }
}
