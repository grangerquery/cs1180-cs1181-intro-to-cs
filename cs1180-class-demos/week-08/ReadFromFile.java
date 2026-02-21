import java.io.FileInputStream;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream(
                "C:\\Users\\brayd\\Documents\\WSU\\2023FALL\\CS1180 + CS1180L\\CS1180 + CS1180L VSCode\\Week 08\\ReadFromFile.txt");
        Scanner file_sc = new Scanner(fis);

        int sum = 0;
        // int num1 = file_sc.nextInt();

        while (file_sc.hasNext()) {
            sum = sum + file_sc.nextInt();
        }

        System.out.println(sum);

        fis.close();
        file_sc.close();
    }
}