public class Icon implements Drawable {
    int x;
    int y;
    String imageFile;

    public Icon (int x, int y, String imageFile) {
        this.x = x;
        this.y = y;
        this.imageFile = imageFile;
    }

    public void draw() {
        System.out.println("Drew the icon at (" + x + ", " + y + ")");
    }
}
