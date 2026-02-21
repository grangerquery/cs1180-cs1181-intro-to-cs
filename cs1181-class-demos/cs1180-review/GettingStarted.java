public class GettingStarted {
    public static void main(String[] args) throws Exception {
        int i = 7;
        double d = 9.3;
        float f = 2.3f; // Floating point
        d = i; // Promotion

        // Can't do this:
        // i = d;

        // Fix it with a typecast
        i = (int) d;

        d = f;
        f = (float) d;

        System.out.println(i);
        System.out.println(d);
        System.out.println(f);
    }
}
