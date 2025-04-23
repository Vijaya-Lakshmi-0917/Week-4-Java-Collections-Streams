import java.util.regex.*;
import java.util.*;

class RepeatingWordsFinder {

    public static List<String> findRepeatingWords(String text) {
        List<String> repeats = new ArrayList<>();
        String pattern = "\\b(\\w+)\\s+\\1\\b";
        Matcher matcher = Pattern.compile(pattern, Pattern.CASE_INSENSITIVE).matcher(text);
        while (matcher.find()) {
            repeats.add(matcher.group(1));
        }
        return repeats;
    }

    public static void main(String[] args) {
        String input = "This is is a repeated repeated word test.";
        List<String> repeatingWords = findRepeatingWords(input);
        for (String word : repeatingWords) {
            System.out.println(word);
        }
    }
}