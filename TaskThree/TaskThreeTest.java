package TaskThree;

import java.io.*;
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

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer value1 = words.get(o1);
                Integer value2 = words.get(o2);
                return value1.compareTo(value2);
            }
        };

        Map<String, Integer> sortedWords = new TreeMap<>(comparator.reversed());
        sortedWords.putAll(words);
        for (Map.Entry<String, Integer> entry : sortedWords.entrySet())
            System.out.println(entry);
        }
    }
