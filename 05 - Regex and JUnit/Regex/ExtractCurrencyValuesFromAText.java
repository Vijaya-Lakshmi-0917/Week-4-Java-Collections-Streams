import java.util.regex.*;
import java.util.*;

class CurrencyExtractor {

    public static List<String> extractCurrencyValues(String text) {
        List<String> values = new ArrayList<>();
        String pattern = "\\$?\\d+\\.\\d{2}";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> values = extractCurrencyValues(text);
        for (String value : values) {
            System.out.println(value);
        }
    }
}
