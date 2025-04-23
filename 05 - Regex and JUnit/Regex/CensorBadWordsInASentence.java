import java.util.*;
import java.util.regex.*;

class BadWordsCensor {

    public static String censorBadWords(String text, List<String> badWords) {
        for (String badWord : badWords) {
            String regex = "\\b" + Pattern.quote(badWord) + "\\b";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, "****");
            }
            matcher.appendTail(sb);
            text = sb.toString();
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        String output = censorBadWords(input, badWords);
        System.out.println(output);
    }
}