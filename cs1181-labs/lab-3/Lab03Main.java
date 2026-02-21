import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class Driver - The driver class for practice problem 3
 * 
 * @author Brayden Granger
 * @since 1/30/2024
 */
public class Lab03Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the square's sides:");
        try {
            double uInput = sc.nextDouble();
            Square uSquare = new Square(uInput);
            System.out.println(uSquare.toString());
            System.out.println("The perimeter of the square is " + uSquare.getPerimeter());
            System.out.println("The area of the square is " + uSquare.getArea());
        } catch (InputMismatchException e) {
            System.out.println("Error: you must enter a number");
        }
        sc.close();
    }
}