import java.util.*;

public class FindFrequencyOfElemnts {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String item : input) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        System.out.println(frequencyMap);
    }
}
