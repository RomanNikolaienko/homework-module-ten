package TaskOne;

import java.io.*;
import java.util.*;

public class TaskOneTest {
    public static void main(String[] args) throws FileNotFoundException {
        String patterns = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[-.]?\\d{4}$";

        List<String> phoneNumbersArrayList = new ArrayList<>();

        FileInputStream fis = new FileInputStream("TaskOne/file.txt");
        Scanner scanner = new Scanner(fis);
        while (scanner.hasNextLine()){
            String phoneNumber = scanner.nextLine();
            phoneNumbersArrayList.add(phoneNumber);
        }
        for (String phoneNumber : phoneNumbersArrayList) {
            if (phoneNumber.matches(patterns)){
                System.out.println(phoneNumber);
            }

        }
    }
}
