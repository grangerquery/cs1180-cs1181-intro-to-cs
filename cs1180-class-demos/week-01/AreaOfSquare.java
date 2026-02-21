import java.util.Scanner;

public class AreaOfSquare {
    public static void main(String[] args) throws Exception {
        //Prompt user for input
        //Print out area of square
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter one side length ");

        double input = sc.nextDouble();

        double area = input * input;

        System.out.println("The area is: " + area);

        sc.close();
    }
}
