/**
 * Song - A class to hold song details.
 * 
 * @author Brayden Granger
 * @since 1/12/2024
 * @see https://example.com Put reference here if applicable
 */
public class Song {
    private String title = new String();

    /**
     * Song - Create a new song with a title
     * 
     * Detailed description of the constructor goes here.
     * It can be multiple lines.
     * 
     * @param newTitle The title of the new song
     */
    public Song(String newTitle) {
        this.title = newTitle;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getTitle() {
        return this.title;
    }
}
