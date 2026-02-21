import java.util.ArrayDeque;
import java.util.ArrayList;
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.exception.*;

/**
 * This program generates each possible combination of three-character and
 * five-character passwords consisting of only lowercase characters in order to
 * crack two zip files of these respective sizes. To crack the five-character
 * zip file, multithreading is used.
 * 
 * javac -cp zip4j-1.3.2.jar *.java
 * java -cp .;zip4j-1.3.2.jar Project
 * 
 * @author Brayden Granger
 * @since 04/18/2024
 */
public class Project {
    public static final int numThreads = 13; // The number of threads, set to 13 for quick testing

    public static void main(String[] args) {
        long programStart = System.currentTimeMillis();
        try {
            crackThreeChar();
        } catch (Exception e) {
            e.printStackTrace();
        }
        crackFiveChar();
        long programEnd = System.currentTimeMillis();
        System.out.println("\nTotal time: " + (programEnd - programStart) + " milliseconds");
    }

    /**
     * Generates an array deque of every possible password of a given length
     * 
     * @param passwordSize The length of the password
     * @return An array deque of every password
     */
    public static ArrayDeque<String> makePasswordList(int passwordSize) {
        ArrayDeque<String> returnList = new ArrayDeque<>();
        returnList.offer("");
        // Loops through the password size
        for (int i = 0; i < passwordSize; i++) {
            int tempSize = returnList.size();
            // Loops through the current deque size
            for (int j = 0; j < tempSize; j++) {
                // Loops through each character
                for (char c = 'a'; c <= 'z'; c++) {
                    returnList.add(returnList.peek() + c);
                }
                returnList.poll();
            }
        }
        return returnList;
    }

    /**
     * Checks every possible combination of three-character-long passwords until the
     * correct password is entered
     * 
     * @throws Exception
     */
    public static void crackThreeChar() throws Exception {
        long threeCharStart = System.currentTimeMillis();
        System.out.println("\nBeginning three-character password cracking");
        System.out.println("---------------------------------------------");
        // It doesn't matter at size = 3, but at greater sizes, using my algorithm, it's
        // far faster to generate an array deque and convert it to an array list than it
        // is to simply generate the array list.
        ArrayList<String> passwords = new ArrayList<String>(makePasswordList(3));
        System.out.println("Successfully generated passwords \tTime elapsed: "
                + (System.currentTimeMillis() - threeCharStart) + " milliseconds");

        // Beginning of password crack
        String correctPassword = "";
        int size = passwords.size();
        ZipFile zipfile = new ZipFile("protected3.zip");
        for (String password : passwords) {
            try {
                zipfile.setPassword(password);
                zipfile.extractAll("protected3-contents");
                correctPassword = password;
                break;
            } catch (ZipException ze) {
                // Incorrect password - do nothing
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cracked password: \'" + correctPassword + "\' \t\tTime elapsed: "
                + (System.currentTimeMillis() - threeCharStart) + " milliseconds");
    }

    /**
     * Checks every possible combination of five-character-long passwords using
     * multithreading until the correct password is entered
     */
    public static void crackFiveChar() {
        long fiveCharStart = System.currentTimeMillis();
        System.out.println("\nBeginning five-character password cracking");
        System.out.println("---------------------------------------------");
        // At size = 5, using my algorithm, it's far faster to generate an array deque
        // and convert it to an array list than it is to simply generate the array list.
        ArrayList<String> passwords = new ArrayList<String>(makePasswordList(5));
        System.out.println("Successfully generated passwords \tTime elapsed: "
                + (System.currentTimeMillis() - fiveCharStart) + " milliseconds");

        // Creation of threads + beginning of password crack
        ArrayList<CrackerThread> threads = new ArrayList<>();
        int size = passwords.size() / numThreads, prev = 0;
        for (int i = 0; i < numThreads; i++) {
            ArrayList<String> crackerList = new ArrayList<String>(passwords.subList(prev, prev + size));
            CrackerThread thread = new CrackerThread(crackerList);
            prev += size;
            threads.add(thread);
            thread.setFolder("protected5-contents-" + i);
            thread.start();
        }

        // Joining of threads
        String correctPassword = "";
        for (CrackerThread thread : threads) {
            try {
                thread.join();
                correctPassword = thread.getCorrectPassword();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Cracked password: \'" + correctPassword + "\' \t\tTime elapsed: "
                + (System.currentTimeMillis() - fiveCharStart) + " milliseconds");
    }
}