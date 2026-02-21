import java.io.*;
import java.util.*;

public class ArrayFromFile {

    /**
     * Prints an array to terminal
     * 
     * @param list an array of integers
     */
    public static void printer(int[] list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\brayd\\Documents\\WSU\\2023FALL\\CS1180 + CS1180L\\CS1180 + CS1180L VSCode\\Week 09\\ArrayFromFile.txt");
        Scanner sc = new Scanner(fis);

        int lines_in_file = 0;

        while (sc.hasNext()) {
            lines_in_file++;
            sc.next();
        }

        int[] fileInts = new int[lines_in_file];
        ArrayList<Integer> fileNums = new ArrayList<Integer>();

        // Close file
        fis.close();
        sc.close();

        // Reopen file
        fis = new FileInputStream(
                "C:\\Users\\brayd\\OneDrive\\Documents\\WSU\\2023FALL\\CS1180 + CS1180L\\CS1180 + CS1180L VSCode\\src\\W9day3.txt");
        sc = new Scanner(fis);

        int i = 0, addNum = 0;

        while (sc.hasNext()) {
            addNum = sc.nextInt();

            // Add to array
            fileInts[i] = addNum;
            i++;

            // Add to array list
            fileNums.add(addNum);
        }

        printer(fileInts);

        System.out.println(fileNums.toString());

        fis.close();
        sc.close();
    }
}
