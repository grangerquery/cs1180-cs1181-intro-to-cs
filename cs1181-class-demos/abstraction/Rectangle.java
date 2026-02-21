public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int x, int y, String color, int height, int width) {
        super(x, y, color);
        // Error checking for height and width
        this.height = height;
        this.width = width;
    }

    public Rectangle(Rectangle other) {
        super(other.getX(), other.getY(), other.getColor());
        height = other.height;
        width = other.width;
    }

    public void draw() {
        System.out.println("Drawing a " + getColor() + " rectangle at (" + getX() + ", " + getY() + ")");
        System.out.println("    Height: " + height + ", Width: " + width);
    }
}
