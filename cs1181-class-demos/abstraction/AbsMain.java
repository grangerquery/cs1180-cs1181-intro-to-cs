import java.util.ArrayList;

public class AbsMain {
    public static void main(String[] args) {
        Shape r = new Rectangle(9, 7, "Red", 5, 3);
        try {
            r.setX(5);
        } catch (IllegalSideLengthException e) {
            System.out.println("Illegal length, try again");
        } catch (Exception e) {
            System.out.println("Problem moving rectangle: ");
            e.printStackTrace();
            return;
        } finally {
            System.out.println("Clearing up");
        }
        r.draw();

        ArrayList<Drawable> things = new ArrayList<Drawable>();
        things.add(new Rectangle(7, 3, "Blue", 4, 9));
        things.add(new Icon(5, 9, "c:\\somefile.png"));

        Drawable dr = things.get(0);
    }
}
