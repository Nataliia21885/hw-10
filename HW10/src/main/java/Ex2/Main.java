package Ex2;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("InputUser.txt");
        List<User> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter writer = new FileWriter("user.json")) {

            String line = bufferedReader.readLine();

            while (line != null) {
                String[] split = line.split(" ");
                User user = new User(split[0], Integer.parseInt(split[1]));
                list.add(user);
                line = bufferedReader.readLine();
            }

            Gson gson = new Gson();
            String userJson = gson.toJson(list);
           // System.out.println(userJson);

            writer.write(userJson);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}