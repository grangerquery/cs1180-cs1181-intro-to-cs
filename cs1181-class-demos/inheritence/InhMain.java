public class InhMain {
    public static void main(String[] args) {
        Raider r = new Student("Granger", "Brayden", 123, 3.3);

        System.out.println(r);
        System.out.println(((Student) r).getGpa()); // Typecasting to use student methods with raider reference
    }
}
