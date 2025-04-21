import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class CountWordsInAFile {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\S Vijaya Lakshmi\\documents\\Java.txt";
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        List<Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCountMap.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, sortedEntries.size()); i++) {
            Entry<String, Integer> entry = sortedEntries.get(i);
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
