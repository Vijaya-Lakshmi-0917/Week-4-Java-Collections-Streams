import java.util.regex.*;
import java.util.*;
class CapitalizedWordsExtractor {

    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        String pattern = "\\b[A-Z][a-zA-Z]*\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> capitalizedWords = extractCapitalizedWords(text);
        for (String word : capitalizedWords) {
            System.out.println(word);
        }
    }
}