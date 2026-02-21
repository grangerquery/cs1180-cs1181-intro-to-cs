import java.util.Scanner;

public class BugDebug {
    public static void main (String[] args) throws Exception {
        Scanner scnr = new Scanner(System.in);
        int biggest = 0, howMany = 0, newNum = 0;

        do {
            howMany = scnr.nextInt();

            for (int i = 0; i < howMany; ++i) {
                newNum = scnr.nextInt();
                System.out.printf("testing %d against %d\n", newNum, biggest);

                if (newNum > biggest) {
                    System.out.println("The biggest so far was " + newNum);
                    biggest = newNum; 
                } 
            }
            System.out.println("The biggest number this round was: " + biggest);
            biggest = 0;
        } while (howMany != 0);

        scnr.close();
    }
}