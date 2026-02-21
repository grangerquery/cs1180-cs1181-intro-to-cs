import java.util.Random;
import javax.swing.JToggleButton;

/**
 * Class Space - Stores the information of a Space object
 * 
 * @author Brayden Granger
 * @since 03/08/2024
 */
public class Space extends JToggleButton {
    private int xPosition; // The horizontal position of the space
    private int yPosition; // The vertical position of the space
    private int numSurroundingMines; // The number of mines surrounding the space
    private boolean isMine; // Whether the space is a mine
    private boolean isRevealed; // Whether the space has been revealed
    private boolean isFlag; // Whether the space is a flag

    /**
     * A space constructor taking no paramters (this might not be used)
     */
    public Space() {
        super();
        isMine = mineRandomizer();
    }

    /**
     * A space constructor taking an x and y position as parameters
     * 
     * @param x The x position
     * @param y The y position
     */
    public Space(int x, int y) {
        super();
        xPosition = x;
        yPosition = y;
        isMine = mineRandomizer();
    }

    /**
     * Uses a random number generator to determine if a given space is a mine (1/8)
     * 
     * @return Whether the space is a mine.
     */
    private boolean mineRandomizer() {
        Random rnd = new Random();
        int num = rnd.nextInt(8);

        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Reveals a given space
     */
    public void reveal() {
        isRevealed = true;
    }

    /**
     * Sets the x position of a given space
     * 
     * @param xPosition The x position
     */
    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Sets the y position of a given space
     * 
     * @param xPosition The x position
     */
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Sets whether the given space is revealed
     * 
     * @param isRevealed Whether the space is revealed
     */
    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    /**
     * Sets the number of mines surrounding a given space
     * 
     * @param numSurroundingMines The number of mines surronding the space
     */
    public void setNumSurroundingMines(int numSurroundingMines) {
        this.numSurroundingMines = numSurroundingMines;
    }

    /**
     * Sets the x position of a given space
     * 
     * @return The x position of the space
     */
    public int getXPosition() {
        return xPosition;
    }

    /**
     * Sets the y position of a given space
     * 
     * @return The y position of the space
     */
    public int getYPosition() {
        return yPosition;
    }

    /**
     * Gets the number of mines surrounding a given space
     * 
     * @return The number of mines surronding the space
     */
    public int getNumSurroundingMines() {
        return numSurroundingMines;
    }

    /**
     * Gets whether a given space is a mine
     * 
     * @return Whether the space is a mine
     */
    public boolean isMine() {
        return isMine;
    }

    /**
     * Gets whether a given space has been revealed
     * 
     * @return Whether the space has been revealed
     */
    public boolean isRevealed() {
        return isRevealed;
    }

    /**
     * Gets whether a given space is a flag
     * 
     * @return Whether the space is a flag
     */
    public boolean isFlag() {
        return isFlag;
    }

    /**
     * Sets whether a given space is a mine
     * 
     * @param isMine Whether the space is a mine
     */
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    /**
     * Sets whether a given space is a flag
     * 
     * @param isFlag Whether the space is a flag
     */
    public void setFlag(boolean isFlag) {
        this.isFlag = isFlag;
    }

    /**
     * Prints the information of a given space (only used for testing purposes)
     */
    @Override
    public String toString() {
        return "(" + getXPosition() + ", " + getYPosition() + ") " + "Mine: " + isMine() + " Surrounding: " + getNumSurroundingMines();
    }
}