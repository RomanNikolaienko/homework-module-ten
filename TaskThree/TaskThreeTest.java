package TaskThree;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class TaskThreeTest {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        try (FileInputStream fis = new FileInputStream("TaskThree/words.txt");
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (words.containsKey(word)) {
                    int count = words.get(word) + 1;
                    words.put(word, count);
                } else {
                    words.put(word, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry);
        }
    }
}
