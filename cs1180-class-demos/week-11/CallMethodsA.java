import java.util.Scanner;

public class CallMethodsA {
    public static void main(String[] args) {
        System.out.print("Give me a string: ");
    
        Scanner sc = new Scanner(System.in);
        String userString = sc.nextLine();
        System.out.println();

        System.out.print("Your string: ");
        CallMethodsB.helloThere(userString);
        
        sc.close();
    }
}