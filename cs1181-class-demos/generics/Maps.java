import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maps {
    public static void main(String[] args) throws Exception {
        Map<Integer, String> checkOuts = new HashMap<>();
        checkOuts.put(123, "Raymer");
        checkOuts.put(345, "Wischgoll");
        checkOuts.put(778, "Raymer");
        checkOuts.put(664, "Doom");
        checkOuts.put(123, "Doom"); // Duplicate key - entry is replaced (Raymer -> Doom)

        // System.out.println(checkOuts.get(345));
        // System.out.println(checkOuts.get(111));

        for (Integer item : checkOuts.keySet()) {
            System.out.println("Item #" + item + " checked out to " + checkOuts.get(item));
        }

        Map<String, Integer> words = new HashMap<>();
        Scanner inFile = new Scanner(new File("Class work\\05 Generics\\Part 2\\MapKeys.txt"));
        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();

            for (String word : line.split("[\\s\\p{Punct}]+")) {
                word = word.toLowerCase();

                Integer count = words.get(word);
                if (count == null) {
                    words.put(word, 1);
                } else {
                    words.put(word, ++count);
                }
            }
        }
        inFile.close();

        ArrayList<String> allKeys = new ArrayList<>(words.keySet());
        Collections.sort(allKeys);
        for (String word : allKeys) {
            System.out.print(word + ": " + words.get(word) + " | ");
        }
    }
}
