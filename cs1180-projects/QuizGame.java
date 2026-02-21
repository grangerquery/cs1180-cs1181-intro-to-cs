import java.util.Scanner;

/*
 * Name: Brayden Granger
 * Class: CS1180L
 * Project #: 1 (Trivia)
 * Due Date: 30 September 2023
 */

public class QuizGame {
    public static void main(String[] args) throws Exception {
        //Asks the user a series of five questions
        //Reads the user's answers and displays CORRECT or INCORRECT
        //  If correct, +1 to numCorrect
        //Inform the user how many questons they got correct at the end (number and percent)

        Scanner sc = new Scanner(System.in);
        double numCorrect = 0;

        //PART 1: QUESTIONS
        //  Question 1 - Integer (1927)
        System.out.println("The first feature film with synchronized sound for dialogue was screened in what year?");
        int qOne = sc.nextInt();
        sc.nextLine();

        if (qOne == 1927) {
            System.out.println("CORRECT");
            numCorrect++;
        }
        else {
            System.out.println("INCORRECT");
        }

        //  Question 2 - String (Charlie Chaplin)
        System.out.println("What is the name of the world-renowned American silent film star who plays the character 'the tramp' in several popular slapstick comedies?");
        String qTwo = sc.nextLine();

        if (qTwo.equalsIgnoreCase("Charlie Chaplin")) {
            System.out.println("CORRECT");
            numCorrect++;
        }
        else {
            System.out.println("INCORRECT");
        }

        //  Question 3 - True/False (True)
        System.out.println("TRUE OR FALSE: Legendary director Stanley Kubrick hated his first feature film so much that he attempted to burn it.");
        String qThree = sc.nextLine();

        if (qThree.equalsIgnoreCase("True")) {
            System.out.println("CORRECT");
            numCorrect++;
        }
        else {
            System.out.println("INCORRECT");
        }

        //  Question 4 - Double (2.9)
        System.out.println("To the nearest hundred million, how many billions of dollars has Avatar, the current highest grossing film in the world, made? (E.g. 5.1 = $5.1 Billion)");
        double qFour = sc.nextDouble();
        sc.nextLine();

        if (qFour == 2.9) {
            System.out.println("CORRECT");
            numCorrect++;
        }
        else {
            System.out.println("INCORRECT");
        }
        
        //  Question 5 - Character (S)
        System.out.println("Jaws, Jurassic Park, and Schindler's List were all directed by the same person whose first and last name both start with what letter?");
        char qFive = sc.next().charAt(0);
        sc.close();

        if (qFive == 's' || qFive == 'S') {
            System.out.println("CORRECT");
            numCorrect++;
        }
        else {
            System.out.println("INCORRECT");
        }

        //PART 2: NUM/PERCENT CORRECT
        System.out.printf("You got %.0f out of 5 correct, for a score of %.0f%%.\n", numCorrect, ((numCorrect / 5.0) * 100));
    }
}