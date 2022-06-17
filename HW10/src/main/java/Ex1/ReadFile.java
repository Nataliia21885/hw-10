package Ex1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
    public static void main(String[] args) {

        File file = new File("InputPhoneNumber.txt");

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {

            Pattern pattern1 = Pattern.compile("^\\(([0-9]){3}\\)\\s([0-9]){3}\\-([0-9]){4}$");
            Pattern pattern2 = Pattern.compile("^([0-9]){3}\\-([0-9]){3}\\-([0-9]){4}$");

            String line = bufferedReader.readLine();

            while (line != null) {

                Matcher matcher1 = pattern1.matcher(line);
                Matcher matcher2 = pattern2.matcher(line);

                if (matcher1.matches() || matcher2.matches()) {
                    System.out.println(line);
                }

                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
