import java.util.Scanner;

public class DisplayBirthday {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        //Prompt user for birthday
        //Split birthday into Day/Month/Year and display
        System.out.println("When were you born? Use the form 4 September 2004.");
        String birthDay = sc.nextLine();

        String[] sp = birthDay.split(" ");
        System.out.println("Day: " + sp[0]);
        System.out.println("Month: " + sp[1]);
        System.out.println("Year: " + sp[2]);

        sc.close();
    }
}
