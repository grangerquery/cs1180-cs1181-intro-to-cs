import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class FileStuff {
    public static void main(String[] args) throws IOException {
        // Creates file
        File file = new File("W8fileStuff.txt");
        file.createNewFile();

        // Outputs to file
        FileOutputStream fos = new FileOutputStream(file, false); // false overwrites file, true adds onto file
        PrintWriter file_out = new PrintWriter(fos);
        file_out.println("67\n67\n42\n12");

        file_out.close();
        fos.close();

        // Reads from file
        FileInputStream fis = new FileInputStream(file);
        Scanner file_sc = new Scanner(fis);

        // Calculates and prints sum from file
        int sum = 0, numCount = 0;

        while (file_sc.hasNext()) {
            sum += file_sc.nextInt();
            numCount++;
        }

        file_sc.close();
        fis.close();

        System.out.println("The average of data in W8fileStuff.txt is " + sum/numCount);
    }
}