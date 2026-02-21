/**
 * A book class
 */
public class Book {
    String title;
    String author;
    String isbn;
    boolean available;
    int condition;

    /**
     * A book constructor
     * 
     * @param title  the title
     * @param author the author
     * @param isbn   the isbn
     */
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
        this.condition = 10;
    }

    /**
     * Returns the title
     * 
     * @return the title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the author
     * 
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Returns the ISBN
     * 
     * @return the ISBN
     */
    public String getISBN() {
        return this.author;
    }

    /**
     * Returns the condition
     * 
     * @return the condition
     */
    public int getCondition() {
        return this.condition;
    }

    /**
     * Sets the condition
     * 
     * @param condition the condition
     */
    public void setCondition(int condition) {
        this.condition = condition;
    }

    /**
     * Sets a book to available
     */
    public void checkout() {
        this.available = false;
    }

    /**
     * Sets a book to unavailable
     */
    public void checkin() {
        this.available = true;
    }

    /**
     * Gets the availability
     * 
     * @return the availability
     */
    public boolean getAvailability() {
        return this.available;
    }

    /**
     * Prints the information of a book
     */
    @Override
    public String toString() {
        return "Title: " + getTitle()
                + "\n\tAuthor: " + getAuthor()
                + "\n\tISBN: " + getISBN()
                + "\n\tAvailable for checkout: " + getAvailability()
                + "\n\tCondition: " + getCondition();
    }
}
