import java.util.regex.*;
import java.util.*;

class LanguageExtractor {

    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        String pattern = "\\b(Java|Python|JavaScript|Go)\\b";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> langs = extractLanguages(text);
        for (String lang : langs) {
            System.out.println(lang);
        }
    }
}