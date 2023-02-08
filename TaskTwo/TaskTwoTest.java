package TaskTwo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class TaskTwoTest {
    public static void main(String[] args) throws IOException {
        List<User> users = new ArrayList<>();

        FileReader fileReader = new FileReader("TaskTwo/file.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<String> list = new ArrayList<>();

        String line;
        int count = 0;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("name age")) {
                continue;
            }
            list.add(count, line);
            String[] arr = line.split(" ");
            users.add(new User(arr[0], Integer.parseInt(arr[1])));
            count++;
        }
        fileReader.close();
        bufferedReader.close();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String toJson = gson.toJson(users);

        OutputStream fos = new FileOutputStream("user.json");
        fos.write(toJson.getBytes());
        fos.close();

    }
}

class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}