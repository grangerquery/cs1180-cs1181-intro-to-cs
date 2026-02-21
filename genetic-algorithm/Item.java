/**
 * Class Item - Holds the information of an item
 * 
 * @author Brayden Granger
 * @since 02/05/2024
 */
public class Item {
    private final String name; // A label for the item, such as “Jewelry” or “Kindle”
    private final double weight; // The weight of the item in pounds
    private final int value; // The value of the item rounded to the nearest dollar
    private boolean included; // Indicates whether the item should be taken or not

    /**
     * Initializes the Item’s fields to the values that are passed in; the included
     * field is initialized to false
     * 
     * @param name   A string representing the new item's name
     * @param weight A double representing the new item's weight
     * @param value  An integer representing the new item's value
     */
    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false;
    }

    /**
     * Initializes this item’s fields to the be the same as the other item’s
     * 
     * @param other The other item
     */
    public Item(Item other) {
        name = other.name;
        weight = other.weight;
        value = other.value;
        included = other.included;
    }

    /**
     * Getter for the item's weight
     * 
     * @return A double representing the item's weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Getter for the item's value
     * 
     * @return An integer representing the item's value
     */
    public int getValue() {
        return value;
    }

    /**
     * Getter for if the item is included
     * 
     * @return A boolean representing whether the item is included
     */
    public boolean isIncluded() {
        return included;
    }

    /**
     * Setter for if the item is included
     * 
     * @param included A boolean representing whether the item is included
     */
    public void setIncluded(boolean included) {
        this.included = included;
    }

    /**
     * Displays the item in the form <name> (<weight> lbs, $<value>)
     * 
     * @return A string of the form <name> (<weight> lbs, $<value>)
     */
    @Override
    public String toString() {
        return name + " (" + weight + " lbs, $" + value + ")";
    }
}
