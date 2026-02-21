import java.util.Scanner;
import java.util.Random;

public class MoreGenerate {
    public static void main(String[] args) throws Exception {
        boolean myBool = 7 == 8;
        myBool = Character.isDigit('9');
        //myBool = false;

        if (5 < 7 && !(4 > 8)) {
            System.out.println("This now prints");
        }

        System.out.println(myBool);
        /* //User input checker (between 0 and 10)
        Scanner sc = new Scanner(System.in);

        System.out.println("Type a number between 0 and 10.");
        int myNum = sc.nextInt();

        if (myNum < 0) {
            System.out.println("Too low.");
        }
        else if (myNum >= 0 && myNum <= 10) {
            System.out.println("Just right.");
        }
        else {
            System.out.println("Too high.");
        }
        System.out.println("See you later."); */

        //User input checker (random number)
        Scanner sc2 = new Scanner(System.in);

        Random randGen = new Random();
        int myRandInt = randGen.nextInt(11);
        
        System.out.println("Type a number between 0 and 10.");
        int myNum2 = sc2.nextInt();

        while (myNum2 != myRandInt) {
            System.out.println("Try again.");
            System.out.println("Type a number between 0 and 10.");
            myNum2 = sc2.nextInt();
        }

        System.out.println("You got it right.");

        sc2.close();
    }
}
