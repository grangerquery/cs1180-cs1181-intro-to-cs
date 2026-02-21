public class Copies {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(7, 8, "White", 5, 9);

        // s changes r, and vice versa
        Rectangle s = r; // Shallow copy
        s.setX(100);
        System.out.println(r.getX()); // X = 100
        r.setX(10);
        System.out.println(s.getX()); // X = 10

        // q and r change separately
        Rectangle q = new Rectangle(r); // Deep copy
        q.setX(50);
        System.out.println(q.getX()); // X = 50
        r.setX(20);
        System.out.println(r.getX()); // X = 20
    }
}
