import java.util.Scanner;

/*
 * Name:     Brayden Granger
 * Title:    Practice Problem 3
 * Class:    CS1180L
 * Due Date: 22 September 2023
 */

public class LibraryFees {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        //Prompts user for # of days late
        //Asks if user is a VIP
        //Calculates and displays late fee
        System.out.print("Enter number of days late: ");
        int daysLate = sc1.nextInt();

        System.out.print("Are you a library VIP (yes / no)? ");
        String vipStatus = sc2.nextLine();

        if (daysLate <= 5 && daysLate >= 1 && vipStatus.equalsIgnoreCase("no")) {        //daysLate: 1-5; vipStatus: No
            System.out.println("Late fine is $1.00 for " + daysLate + " days late.");
        }
        else if (daysLate <=5 && daysLate >= 1 && vipStatus.equalsIgnoreCase("yes")) {   //daysLate: 1-5; vipStatus: Yes
            System.out.println("Late fine is $0.50 for " + daysLate + " days late.");
        }
        else if (daysLate >= 6 && daysLate <= 10 && vipStatus.equalsIgnoreCase("no")) {  //daysLate: 6-10; vipStatus: No
            System.out.println("Late fine is $5.00 for " + daysLate + " days late.");
        }
        else if (daysLate >= 6 && daysLate <= 10 && vipStatus.equalsIgnoreCase("yes")) { //daysLate: 6-10; vipStatus: Yes
            System.out.println("Late fine is $2.50 for " + daysLate + " days late.");
        }
        else if (daysLate > 10 && vipStatus.equalsIgnoreCase("no")) {                    //daysLate: 10+; vipStatus: No
            System.out.println("Late fine is $10.00 for " + daysLate + " days late.");
        }
        else if (daysLate > 10 && vipStatus.equalsIgnoreCase("yes")) {                   //daysLate: 10+; vipStatus: Yes
            System.out.println("Late fine is $5.00 for " + daysLate + " days late.");
        }
        else {                                                                           //daysLate: 0 or fewer; vipStatus: Any
            System.out.println("You are not late.");
        }

        //Close scanner
        sc1.close();
        sc2.close();
    }
}
