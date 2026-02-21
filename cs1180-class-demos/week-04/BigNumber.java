import java.util.Scanner;

public class BigNumber {
    public static void main(String[] args) throws Exception {
        // prompt user for number of numbers
        Scanner sc = new Scanner(System.in);

        System.out.println("How many numbers to evaluate?");
        int numOfNums = sc.nextInt();
        int num1 = 0;
        //integer to hold bignum
        //int bigNum = sc.nextInt();
        int bigNum = 0;
        
        // for loop to do what: 
        for (int i = numOfNums; i > 0; i--) {
            System.out.println("Give me a number: ");
            //scan for nums
            num1 = sc.nextInt();
            System.out.println("User entered: " + num1);
            if (num1 > bigNum) {
                System.out.println("New big number found");
                bigNum = num1;
            }
        }
        // print bigger number
        System.out.println("Biggest number is: " + bigNum);

        sc.close();
    }
}
