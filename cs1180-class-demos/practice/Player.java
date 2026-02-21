import java.util.Random;

/**
 * A player class for a turn-based RPG
 * 
 * @author Brayden Granger
 */
public class Player {
    private String name; // The player's name
    private int health; // The player's health
    private int maxDamage; // The maximum damage the player can deal

    /**
     * A player constructor that takes name and maxDamage as parameters
     * 
     * @param name      the player's name
     * @param maxDamage the maximum damage the player can deal
     */
    public Player(String name, int maxDamage) {
        this.name = name;
        this.health = 100;
        this.maxDamage = maxDamage;
    }

    /**
     * Sets the player's name
     * 
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the player's name
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the player's health
     * 
     * @param health the health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the player's health
     * 
     * @return the health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Sets the maximum damage the player can deal
     * 
     * @param maxDamage the maximum damage
     */
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    /**
     * Gets the maximum damage the player can deal
     * 
     * @return the maximum damage
     */
    public int getMaxDamage() {
        return this.maxDamage;
    }

    /**
     * Deals damage to another player
     * 
     * @param other the other player
     */
    public void dealDamage(Player other) {
        Random rnd = new Random();
        int dmg = rnd.nextInt(other.getMaxDamage() + 1); // [0 to maxDamage] instead of [0 to maxDamage - 1]
        setHealth(getHealth() - dmg);
    }

    /**
     * Prints info of a player to the terminal in the form:
     * "name: HP health"
     * 
     * @return the info of a player
     */
    @Override
    public String toString() {
        return this.name + ": HP " + this.health;
    }
}
