import java.util.Scanner;

public class NestedMethods {
    public static void printSquare(int sideLength) {
        for (int i = 0; i < sideLength; i++) {
            for (int j = 0; j < sideLength; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static int checkInput(int sideLength) {
        if (sideLength > 0) {
            return sideLength;
        } else if (sideLength == 0) {
            return 0;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sideLength = 0;

        do {
            sideLength = sc.nextInt();
            printSquare(sideLength);
        } while (checkInput(sideLength) != 0);

        sc.close();
    }
}