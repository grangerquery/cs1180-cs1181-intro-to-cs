public class BreakAndContinue {
    public static void main(String[] args) throws Exception {
        // while loop that prints 0 to 10 BUT when 7 print Lucky number!
        int num = 0;
        while (num <= 10) {
            if (num == 7) {
                System.out.println("Lucky number!");
                break;
            }
            System.out.print(num + " ");
            num++;
        }
        System.out.println("In the escape zone");
    }
}
