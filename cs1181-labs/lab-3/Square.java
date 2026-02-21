/**
 * Class Square - Contains the information of a single square
 * 
 * @author Brayden Granger
 * @since 1/30/2024
 */
public class Square {
    private double side; // The square's side length

    /**
     * Square - Creates a new square object
     * 
     * @param side A double representing the new square object's side length
     */
    public Square(double side) {
        try {
            if (side >= 0) {
                this.side = side;
            } else {
                throw new NegativeLengthException();
            }
        } catch (NegativeLengthException e) {
            System.out.println("Negative length: " + side);
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Prints the information of a square object to the terminal
     * 
     * @return A string of the form 'Square with side = <side>'
     */
    @Override
    public String toString() {
        return "Square with side = " + side;
    }

    /**
     * Gets the perimeter of a square object
     * 
     * @return A double representing <side> * 4
     */
    public double getPerimeter() {
        return side * 4;
    }

    /**
     * Gets the area of a square object
     * 
     * @return A double representing <side> * <side>
     */
    public double getArea() {
        return side * side;
    }
}