import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Give me a string: ");
        String userString = sc.nextLine();

        int stringLength = userString.length();

        for (int i = 0; i < stringLength; ++i) {
            System.out.print(userString.charAt(i) + "" + userString.charAt(i));
        }
        sc.close();
    }
}