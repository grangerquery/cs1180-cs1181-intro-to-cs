import java.util.Scanner;

public class StringThings {
    public static void main (String[] args) throws Exception {
        // My sentence is bananas!
        Scanner sc = new Scanner(System.in);

        System.out.println("Provide a string.");
        String userString = sc.nextLine();

        // Print a space between each character
        int stringLength = userString.length();
        System.out.println("User gave a string of length: " + stringLength);

        String saveIt = "";

        for (int i = 0; i < stringLength; i++) {
            System.out.print(userString.charAt(i) + " ");
            saveIt += userString.charAt(i) + " ";
        }
        userString = saveIt.replace('a', '@');
        System.out.println();
        System.out.println(userString);

        sc.close();
    }
}
