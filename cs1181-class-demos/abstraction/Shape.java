public abstract class Shape implements Drawable {
    private int x;
    private int y;
    private String color;

    public Shape(int x, int y, String color) {
        // Error checking
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void setX(int x) {
        if (x <= 0) {
            throw new IllegalSideLengthException();
        }
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public abstract void draw();
}
