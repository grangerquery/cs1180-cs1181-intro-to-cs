import java.io.*;
import java.util.*;

/**
 * This program is a game loosely based on "Spelling Bee" from the New York
 * times. The user will be presented with 7 unique characters, and they must
 * use the characters to make as many 4+ letter words as they can.
 * 
 * @author Brayden Granger
 */
public class SpellingBee2 {

    /**
     * Generates a random word from the words.txt file and converts it to a
     * character arraylist
     * 
     * @return the character arraylist
     * @throws IOException
     */
    public static ArrayList<Character> getWordFromFile() throws IOException {
        try {
            FileInputStream fis = new FileInputStream("words.txt");
            Scanner file_sc = new Scanner(fis);

            // Counts the number of words in the file
            int countedLines = 0;
            while (file_sc.hasNext()) {
                countedLines++;
                file_sc.nextLine();
            }

            // Closes and reopens the file
            fis.close();
            file_sc.close();
            fis = new FileInputStream("words.txt");
            file_sc = new Scanner(fis);

            // Generates a random line number
            Random rnd = new Random();
            int lineOfWord = rnd.nextInt(countedLines);

            // Finds the word located at the generated line number
            String word = "";
            countedLines = 0;
            while (file_sc.hasNext()) {
                countedLines++;
                file_sc.nextLine();

                if (lineOfWord == countedLines) {
                    word = file_sc.nextLine();
                    break;
                }
            }

            // Turns the word into a character arraylist
            ArrayList<Character> charArrayList = new ArrayList<Character>();
            for (int i = 0; i < word.length(); i++) {
                charArrayList.add(word.charAt(i));
            }

            // Closes the file and returns the arraylist
            fis.close();
            file_sc.close();
            return charArrayList;
        } catch (FileNotFoundException e) {
            // If words.txt cannot be found, returns an empty character arraylist
            ArrayList<Character> charArrayList = new ArrayList<Character>();
            return charArrayList;
        }
    }

    /**
     * Checks if a character arraylist is valid. For a character arraylist to be
     * valid, it must be seven characters long and only have unique characters
     * 
     * @param charArrayList a character arraylist
     * @return whether the character arraylist is valid
     */
    public static Boolean wordIsValid(ArrayList<Character> charArrayList) {
        if (charArrayList.size() == 7) {
            for (int i = 0; i < charArrayList.size(); i++) {
                for (int j = i + 1; j < charArrayList.size(); j++) {
                    if (charArrayList.get(i) == charArrayList.get(j)) {
                        return false; // Returns false if arraylist has multiple of one character
                    }
                }
            }
            return true; // Returns true if arraylist is 7 characters and has only unique characters
        } else {
            return false; // Returns false if arraylist is not 7 characters
        }
    }

    /**
     * Scrambles a character arraylist. This method should only be called after the
     * method wordIsValid returns true
     * 
     * @param charArrayList the character arraylist to be scrambled
     * @return the scrambled arraylist
     */
    public static ArrayList<Character> scrambleWord(ArrayList<Character> charArrayList) {
        Random rnd = new Random();
        int randNum = 0;
        char temp = '\0';

        // 1000 is a completely arbitrary number; adds and removes 1000 times
        for (int i = 0; i < 1000; i++) {
            // Generates a random number
            randNum = rnd.nextInt(charArrayList.size() - 1);

            // Assigns the random number to a temporary character
            temp = charArrayList.get(randNum);

            // Removes then adds the temporary character to the arraylist
            charArrayList.remove(charArrayList.get(randNum));
            charArrayList.add(temp);
        }

        return charArrayList; // Returns the scrambled arraylist
    }

    /**
     * Checks if the user input is valid. For the user input to be valid, it must
     * exist in the words.txt file and only contain characters in the provided
     * character arraylist parameter
     * 
     * @param userInput     the user input
     * @param charArrayList the character arraylist
     * @return whether the user input is valid
     * @throws IOException
     */
    public static boolean checkInput(String userInput, ArrayList<Character> charArrayList) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("words.txt");
            Scanner file_sc = new Scanner(fis);
            boolean existsInFile = false;

            // Checks if user input exists in the words.txt file
            String tempWord = "";
            while (file_sc.hasNext()) {
                tempWord = file_sc.nextLine();

                if (userInput.strip().equalsIgnoreCase(tempWord.strip())) {
                    existsInFile = true;
                }
            }

            fis.close();
            file_sc.close();

            // If user input exists in the file words.txt, checks if user input only
            // contains characters in the arraylist
            if (existsInFile) {
                int matches = 0;
                for (int i = 0; i < charArrayList.size(); i++) {
                    for (int j = 0; j < userInput.length(); j++) {
                        if (userInput.charAt(j) == charArrayList.get(i)) {
                            matches++;
                        }
                    }
                    if (matches == userInput.length()) {
                        return true; // Returns true if user input only contains characters in the arraylist
                    }
                }
                return false; // Returns false if user input does not only contain characters in the arraylist
            } else {
                return false; // Returns false if user input does not exist in the file words.txt
            }
        } catch (FileNotFoundException e) {
            return false; // Returns false if the file words.txt cannot be found
        }
    }

    /**
     * Calculates the score based on user input. This method should only be called
     * after the method checkInput returns true
     * 
     * @param userInput the user input
     * @return the score
     */
    public static int calculateScore(String userInput) {
        int addScore = 0;

        // Calculates score based on length of user input
        switch (userInput.length()) {
            case 0, 1, 2, 3:
                addScore += 0;
                break;
            case 4:
                addScore++;
                break;
            default:
                addScore += userInput.length();
                break;
        }
        return addScore; // Returns the score
    }

    /**
     * The main method
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Character> fileWord = new ArrayList<Character>();
        Scanner sc = new Scanner(System.in);
        String userInput = "", validWords = "";
        int score = 0;

        // Keeps generating new words until one has exactly 7 unique characters
        do {
            fileWord = getWordFromFile();
        } while (!wordIsValid(fileWord));

        // Scrambles the valid word and prints to terminal
        fileWord = scrambleWord(fileWord);
        for (char charr : fileWord) {
            System.out.print("\t" + charr);
        }
        System.out.println();

        // Keeps taking input from terminal until user writes "bye"
        System.out.print("Next word: ");
        userInput = sc.nextLine();
        while (!userInput.strip().equalsIgnoreCase("bye")) {
            // If user input equals "mix", scramble and print again
            if (userInput.strip().equalsIgnoreCase("mix")) {
                fileWord = scrambleWord(fileWord);
                for (char charr : fileWord) {
                    System.out.print("\t" + charr);
                }
                System.out.println();
            }

            // If user input equals "ls", prints all valid words the user has entered so far
            if (userInput.strip().equalsIgnoreCase("ls")) {
                System.out.print(validWords);
            }

            // If user input exists in words.txt, only contains characters in the arraylist,
            // and hasn't been typed before, calculates score then adds user input to a list
            // of valid words
            if (checkInput(userInput, fileWord) && !validWords.contains(userInput)) {
                score += calculateScore(userInput);
                System.out.println("Score: " + score);

                validWords += "\t" + userInput + "\n";
            } else {
                System.out.println("Score: " + score);
            }

            System.out.print("Next word: ");
            userInput = sc.nextLine();
        }
        sc.close();
    }
}