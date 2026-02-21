import java.util.Scanner;
import java.lang.Math;

public class SphereVolume {
    public static void main(String[] args) throws Exception {
        //Prompt user for input
        //Print out volume of sphere
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the radius of the sphere? ");

        double input = sc.nextDouble();

        double volume = (4/3.0) * Math.PI * Math.pow(input, 3);

        System.out.printf("The sphere's volume is %.2f", volume);

        sc.close();
    }
}
