import java.util.Scanner;
import java.util.Random;

/*
 *  Student: Brayden Granger
 *  Class: CS1180L
 *  Due date: 14 October 2023
 *  Description: This program is an interactive game of Simon Says wherein the user must choose a
 *      valid difficulty then repeat a random sequence of four colors (easy mode) or ten numbers
 *      (hard mode) that the program generates. The program keeps track of and displays how many
 *      sequences the user gets correct in a row. If the user gets a sequence wrong or gets all
 *      sequences correct, the program prompts the user for whether they want to play again.
 */

public class SimonSays {
    // Method that clears screen after 3 seconds
    public static void clearScreen() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        // Declaring and initializing stuff
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        Boolean validDifficulty = false, validChoice = false;
        String nextColor = "", saveIt = "";
        int numCorrect = 0;

        // Output begins
        System.out.println("Let's play Simon Says!");

        do {
            // User chooses difficulty
            System.out.print("Select a difficulty (easy / hard): ");
            String difficulty = sc.nextLine();

            // EASY MODE - 4 COLORS
            if (difficulty.replace(" ", "").equalsIgnoreCase("easy")) {
                validDifficulty = true;
                System.out.println("Easy mode - colors");

                for (int i = 0; i < 4; i++) {
                    System.out.print("Simon says: ");
                    int randColor = rnd.nextInt(4);

                    // Assigns nextColor based on randColor
                    switch (randColor) {
                        case 0:
                            nextColor = "yellow";
                            break;
                        case 1:
                            nextColor = "green";
                            break;
                        case 2:
                            nextColor = "red";
                            break;
                        case 3:
                            nextColor = "blue";
                            break;
                        default:
                            System.out.println("how did this happen");
                            break;
                    }
                    // Saves and prints the full sequence of nextColor
                    saveIt += nextColor + " ";
                    System.out.print(saveIt);

                    // After clearing screen, user must repeat the sequence of nextColor
                    clearScreen();
                    System.out.print("Player repeats: ");
                    String userInput = sc.nextLine();

                    // Checks if user is correct, ignoring spaces and case
                    if (userInput.replace(" ", "").equalsIgnoreCase(saveIt.replace(" ", ""))) {
                        numCorrect++;
                        System.out.println("Score: " + numCorrect);
                    } else {
                        System.out.println("Score: " + numCorrect);
                        break;
                    }
                }
                // Output ends
                System.out.println("Round over! Your score was " + numCorrect);

                // Asks if the user wants to go again
                do {
                    System.out.println("Would you like to play another round? (yes / no) ");
                    String goAgain = sc.nextLine();

                    // YES
                    if (goAgain.replace(" ", "").equalsIgnoreCase("yes")) {
                        validDifficulty = false;
                        validChoice = true;
                        nextColor = "";
                        saveIt = "";
                        numCorrect = 0;
                    }
                    // NO
                    else if (goAgain.replace(" ", "").equalsIgnoreCase("no")) {
                        validChoice = true;
                        System.out.println("Thanks for playing!");
                    }
                    // INVALID
                    else {
                        validChoice = false;
                        System.out.println("Invalid response");
                    }
                } while (!validChoice);
            }

            // HARD MODE - 10 NUMBERS
            else if (difficulty.replace(" ", "").equalsIgnoreCase("hard")) {
                validDifficulty = true;
                System.out.println("Hard mode - numbers");

                for (int i = 0; i < 10; i++) {
                    System.out.print("Simon says: ");
                    int randNum = rnd.nextInt(10);

                    // Saves and prints the full sequence of randNum
                    saveIt += randNum + " ";
                    System.out.print(saveIt);

                    // After clearing screen, user must repeat the sequence of randNum
                    clearScreen();
                    System.out.print("Player repeats: ");
                    String userInput = sc.nextLine();

                    // Checks if user is correct, ignoring spaces and case
                    if (userInput.replace(" ", "").equalsIgnoreCase(saveIt.replace(" ", ""))) {
                        numCorrect++;
                        System.out.println("Score: " + numCorrect);
                    } else {
                        System.out.println("Score: " + numCorrect);
                        break;
                    }
                }
                // Output ends
                System.out.println("Round over! Your score was " + numCorrect);

                // Asks if the user wants to go again
                do {
                    System.out.println("Would you like to play another round? (yes / no) ");
                    String goAgain = sc.nextLine();

                    // YES
                    if (goAgain.replace(" ", "").equalsIgnoreCase("yes")) {
                        validDifficulty = false;
                        validChoice = true;
                        nextColor = "";
                        saveIt = "";
                        numCorrect = 0;
                    }
                    // NO
                    else if (goAgain.replace(" ", "").equalsIgnoreCase("no")) {
                        validChoice = true;
                        System.out.println("Thanks for playing!");
                    }
                    // INVALID
                    else {
                        validChoice = false;
                        System.out.println("Invalid response");
                    }
                } while (!validChoice);
            }

            // INVALID MODE
            else {
                validDifficulty = false;
                System.out.println("Invalid difficulty");
            }
        } while (!validDifficulty);
        sc.close();
    }
}