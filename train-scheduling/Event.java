/**
 * Class Event - Stores the information of the events that take place
 * 
 * @author Brayden Granger
 * @since 03/27/2024
 */
public class Event implements Comparable<Event> {
    private double time; // The time when the event takes place
    private String description; // A description of the event

    /**
     * An event constructor taking a time and description as parameters
     * 
     * @param time        The time
     * @param description The description
     */
    public Event(double time, String description) {
        this.time = time;
        this.description = description;
    }

    /**
     * Gets the event's time
     * 
     * @return The time
     */
    public double getTime() {
        return time;
    }

    /**
     * Gets the event's description
     * 
     * @return The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the event's time
     * 
     * @param time The time
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Sets the event's description
     * 
     * @param description The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Compares two events using their times
     * 
     * @param other The other events
     * @return 1, -1, or 0
     */
    @Override
    public int compareTo(Event other) {
        // This time > other time
        if (time > other.getTime()) {
            return 1;
        }
        // This time < other time
        else if (time < other.getTime()) {
            return -1;
        }
        // Priority: Train > Waiting > Crossing
        else {
            // This is train, other is not train
            if (description.contains("TRAIN") && !other.getDescription().contains("TRAIN")) {
                return -1;
            }
            // This is not train, other is train
            else if (!description.contains("TRAIN") && other.getDescription().contains("TRAIN")) {
                return 1;
            }
            // This is truck waiting, other is not truck waiting
            else if (description.contains("waits") && !other.getDescription().contains("waits")) {
                return -1;
            }
            // This is not truck waiting, other is truck waiting
            else if (!description.contains("waits") && other.getDescription().contains("waits")) {
                return 1;
            }
            // This is truck crossing, other is not truck crossing
            else if (description.contains("crosses") && !other.getDescription().contains("crosses")) {
                return -1;
            }
            // This is not truck crossing, other is truck crossing
            else if (!description.contains("crosses") && other.getDescription().contains("crosses")) {
                return 1;
            }
            // Other events are not taken into consideration when sorting
            else {
                return 0;
            }
        }
    }

    /**
     * Turns an event into a human-readable string
     * 
     * @return An event in the form '<time> <description>'
     */
    @Override
    public String toString() {
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";
        // Makes trains events have a red output
        if (description.contains("TRAIN")) {
            return RED + time + ": " + description + RESET;
        } else {
            return time + ": " + description;
        }
    }
}