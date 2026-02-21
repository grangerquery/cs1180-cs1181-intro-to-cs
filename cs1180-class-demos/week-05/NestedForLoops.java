public class NestedForLoops {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("i is: " + i);
            for (int j = 0; j < 10; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        for (int i = 65; i < 70; i++) {
            for (int j = 65; j <= i; j++) {
                char num = (char)j;
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}