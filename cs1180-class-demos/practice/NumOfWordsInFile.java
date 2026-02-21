import java.io.*;
import java.util.Scanner;

public class NumOfWordsInFile {

    /**
     * Creates a file, writes provided string to file, returns File object
     * 
     * @param fileName The name of the file as provided by the user
     * @param s        The text to be written to the file as provided by the user
     * @return The created file with the user-provided text
     * @throws Exception
     */
    public static File writeText(String fileName, String s) throws Exception {
        // Creates File f from user input fileName
        File f = new File(fileName);

        f.createNewFile();

        // Necessary for printing to a file
        FileOutputStream fos = new FileOutputStream(fileName);
        PrintWriter outFS = new PrintWriter(fos);

        // Writes user input s to File f
        outFS.println(s);
        outFS.close();

        return f;
    }

    /**
     * Counts number of words in file
     * A word is any text separated by a whitespace
     * 
     * @param f The created file with the user-provided text from method writeText()
     * @return The number of words contained in the file
     * @throws Exception
     */
    public static int countWords(File f) throws Exception {
        Scanner file_sc = new Scanner(f); // Declares and initializes Scanner file_sc that reads from File f
        int numberOfWords = 0;

        while (file_sc.hasNext()) {
            file_sc.next(); // Makes sure white space does not freeze program
            numberOfWords++;
        }

        file_sc.close();
        return numberOfWords;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Prompts user for file name and what to print
        System.out.println("What is the name of the file? ");
        String fileName = sc.nextLine();

        System.out.println("What would you like to print to the file?");
        String s = sc.nextLine();

        // Executes methods
        File f = writeText(fileName, s);
        int numberOfWords = countWords(f);

        // Prints the number of words in the file
        System.out.println(fileName + " contains " + numberOfWords + " words");

        sc.close();
    }
}