
//import Scanner
import java.util.Scanner;
import java.lang.Math;

public class Variables {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        System.out.println("I have lost 75 lbs so far.");

        //integer
        int num1 = 9;

        System.out.println("The value of num1 is: " + num1);

        int num2 = 11;
        int sum = num1 + num2;
        System.out.println("Sum of num1 + num2: " + sum);

        System.out.println("Give me a number: ");
        Scanner sc = new Scanner(System.in);

        double userInput = sc.nextDouble();
        System.out.println("You gave me: " + userInput);
        // + , - , * , / , exponents, squareroots, cos, sin, tan
        System.out.println(Math.pow(4,5));

        sc.close();

        //long
        //short

        //strings
        //characters
        
        //booleans
    }
}
