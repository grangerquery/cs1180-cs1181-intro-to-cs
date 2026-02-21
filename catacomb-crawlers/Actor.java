import java.util.Random;

/**
 * An actor class, which represents a monster or hero in the catacombs
 * 
 * @author Brayden Granger
 */
public class Actor {
    private String name; // The actor's name
    private int health; // The actor's health
    private int maxDamage; // The maximum damage the actor can deal
    private int row; // The row in the catacombs where the actor is located
    private int col; // The column in the catacombs where the actor is located
    private int gold; // The number of gold the actor has collected

    /**
     * An actor object constructor that takes a name and health as parameters
     * 
     * @param name      a string representing the actor's name
     * @param health    an integer representing the actor's health
     * @param maxDamage an integer representing the actor's maximum damage
     */
    public Actor(String name, int health, int maxDamage) {
        this.name = name;
        this.health = health;
        this.maxDamage = maxDamage;
        this.gold = 0;
    }

    /**
     * Checks whether the given actor is alive (health is > 0)
     * 
     * @return a boolean representing whether the actor is alive
     */
    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether the given actor has escaped (at exit)
     * 
     * @param dungeonSize an integer representing the size of the dungeon
     * @return a boolean representing whether the actor has escaped
     */
    public boolean hasEscaped(int dungeonSize) {
        if (getRow() == dungeonSize && getCol() == dungeonSize) { // Exit is at (dungeonSize, dungeonSize)
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether the given actor is in the same room as another actor
     * 
     * @param other an object representing another actor
     * @return a boolean representing whether the actors are in the same room
     */
    public boolean inSameRoom(Actor other) {
        if (getRow() == other.row && getCol() == other.col) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks whether the given actor is adjacent to another actor (one space away)
     * 
     * @param other an object representing another actor
     * @return a boolean representing whether the actor is adjacent to another actor
     */
    public boolean inAdjacentRoom(Actor other) {
        // Only checks one space for each of the four directions
        if (getRow() + 1 == other.row && getCol() == other.col) {
            return true;
        } else if (getRow() - 1 == other.row && getCol() == other.col) {
            return true;
        } else if (getRow() == other.row && getCol() + 1 == other.col) {
            return true;
        } else if (getRow() == other.row && getCol() + 1 == other.col) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Has two actors exchange a single blow
     * 
     * @param other an object representing another actor
     */
    public void exchangeBlows(Actor other) {
        Random rnd = new Random();

        // Generates two damage numbers
        int thisDamage = rnd.nextInt(this.maxDamage) + 1;
        int otherDamage = rnd.nextInt(other.maxDamage) + 1;

        // User hits first
        other.health = other.health - thisDamage;
        System.out.println("You hit for " + thisDamage);
        if (other.isAlive()) { // Monster hits second only if they are alive
            this.health = this.health - otherDamage;
            System.out.println("You get hit for " + otherDamage);
        }
    }

    /**
     * Sets the health of an actor
     * 
     * @param health an integer representing the health of the actor
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the health of an actor
     * 
     * @return an integer representing the health of the actor
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Sets the row of an actor
     * 
     * @param row an integer representing the actor's row
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Gets the row of an actor
     * 
     * @return an integer representing the actor's row
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets the column of an actor
     * 
     * @param col an integer representing the actor's column
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Gets the column of an actor
     * 
     * @return an integer representing the actor's column
     */
    public int getCol() {
        return this.col;
    }

    /**
     * Sets the gold of an actor
     * 
     * @param gold an integer representing the actor's gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * Gets the gold of an actor
     * 
     * @return an integer representing the actor's gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * Checks if an actor can move in the specified direction
     * 
     * @param direction   a string representing the direction (NESW)
     * @param dungeonSize an integer representing the size of the dungeon
     * @return a boolean representing whether the actor can move in the direction
     */
    public boolean canMove(String direction, int dungeonSize) {
        switch (direction) {
            case "north":
                if (getRow() - 1 < 0) {
                    return false;
                } else {
                    return true;
                }
            case "east":
                if (getCol() + 1 > dungeonSize--) {
                    return false;
                } else {
                    return true;
                }
            case "south":
                if (getRow() + 1 > dungeonSize--) {
                    return false;
                } else {
                    return true;
                }
            case "west":
                if (getCol() - 1 < 0) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }

    /**
     * Converts an actor object to a printable string
     * 
     * @return a string representing an actor of the form
     *         "name at (col, row) with health health"
     */
    @Override
    public String toString() {
        return this.name + " at (" + this.col + ", " + this.row + ") with " + this.health + " health and " + this.gold
                + " gold";
    }
}