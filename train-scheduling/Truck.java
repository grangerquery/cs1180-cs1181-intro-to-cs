/**
 * Class Truck - Stores the information of objects of the truck class
 * 
 * @author Brayden Granger
 * @since 03/25/2024
 */
public class Truck {
    private double TRUCK_START; // The time when the truck starts
    private double TRUCK_AT_CROSSING; // The time when the truck reaches the train crossing
    private double TRUCK_CROSS; // The time when the truck crosses the train tracks
    private double TRUCK_END; // The time when the truck has reached its destination
    private int identifier; // A numerical value associated with the truck

    /**
     * A truck constructor taking an indentifier as a constructor
     * 
     * @param identifier The identifier
     */
    public Truck(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Gets the truck's start time
     * 
     * @return The start time
     */
    public double getStart() {
        return TRUCK_START;
    }

    /**
     * Gets the truck's time at train crossing
     * 
     * @return The time at train crossing
     */
    public double getAtCrossing() {
        return TRUCK_AT_CROSSING;
    }

    /**
     * Gets the truck's time when crossing the train tracks
     * 
     * @return The time when crossing the train tracks
     */
    public double getCross() {
        return TRUCK_CROSS;
    }

    /**
     * Gets the truck's time when it has reached its destination
     * 
     * @return The time when it has reached its destination
     */
    public double getEnd() {
        return TRUCK_END;
    }

    /**
     * Gets the truck's identifier
     * 
     * @return The identifier
     */
    public int getIdentifier() {
        return identifier;
    }

    /**
     * Sets the truck's start time
     * 
     * @param TRUCK_START The start time
     */
    public void setStart(double TRUCK_START) {
        this.TRUCK_START = TRUCK_START;
    }

    /**
     * Sets the truck's time at train crossing
     * 
     * @param TRUCK_AT_CROSSING The time at train crossing
     */
    public void setAtCrossing(double TRUCK_AT_CROSSING) {
        this.TRUCK_AT_CROSSING = TRUCK_AT_CROSSING;
    }

    /**
     * Sets the truck's time when crossing the train tracks
     * 
     * @param TRUCK_CROSS The time when crossing the train tracks
     */
    public void setCross(double TRUCK_CROSS) {
        this.TRUCK_CROSS = TRUCK_CROSS;
    }

    /**
     * Sets the truck's time when it has reached its destination
     * 
     * @param TRUCK_END The time when it has reached its destination
     */
    public void setEnd(double TRUCK_END) {
        this.TRUCK_END = TRUCK_END;
    }

    /**
     * Gets the truck's total time
     * 
     * @return The total time
     */
    public double totalTime() {
        return TRUCK_END - TRUCK_START;
    }
}