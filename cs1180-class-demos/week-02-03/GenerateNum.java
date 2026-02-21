import java.util.Scanner;
import java.util.Random;

public class GenerateNum {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        /*
        //Prompt user for phone number
        System.out.println("Give me a phone number: (ex. 9372605337) ");
        String phoneNum = sc.nextLine();

        //Display area code - Area code: 937
        System.out.println("Area code: " + phoneNum.substring(0, 3));

        //Display phone number - (937) 260-5337
        System.out.println("(" + phoneNum.substring(0, 3) + ") " + phoneNum.substring(3, 6) + "-" + phoneNum.substring(6, 10));
        */


        Random rnd = new Random();
        int myRandInt = rnd.nextInt(3);
        System.out.print("My random number is: " + myRandInt);

        sc.close();
    }
}
