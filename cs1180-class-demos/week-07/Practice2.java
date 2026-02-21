import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int dayOfWeek = sc.nextInt();
        Boolean onVacation = sc.nextBoolean();

        if (dayOfWeek != 0 && dayOfWeek != 6 && onVacation == false) { // Weekday + no vacation
            System.out.println("Alarm set to 7:00 A.M.");
        } else if (dayOfWeek == 0 || dayOfWeek == 6 && onVacation == false) { // Weekend + no vacation
            System.out.println("Alarm set to 10:00 A.M.");
        } else if (dayOfWeek != 0 && dayOfWeek != 6 && onVacation == true) { // Weekday + vacation
            System.out.println("Alarm set to 10:00 A.M.");
        } else { // Weekend + vacation
            System.out.println("Set alarm to off.");
        }

        sc.close();
    }
}