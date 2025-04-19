import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\W_]+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Word Frequency: " + wordFrequency);
    }
}