public class Exceptions {
    public static void main(String[] args) {
        try {
            int i = 7 / 0;
            System.out.println("Finished dividing");
        } catch (ArithmeticException e) {
            System.out.println("Division error");
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return;
        } finally {
            System.out.println("Cleaning up");
        }
        System.out.println("Program done");
    }
}
