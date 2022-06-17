package Ex3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsFile {
    public static void main(String[] args) {
        File file = new File("InputWords.txt");
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            String line = bufferedReader.readLine();
            List<String> list = new ArrayList<>();
            Map<String, Integer> map = new HashMap<>();

            while (line != null) {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    list.add(words[i]);
                }
                line = bufferedReader.readLine();
            }

            for (String words : list) {
                if (map.containsKey(words)) {
                    map.put(words, map.get(words) + 1);
                    continue;
                }
                map.put(words, 1);
            }

            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed())
                    .forEach(s -> System.out.println(s.getKey() + " " + s.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
