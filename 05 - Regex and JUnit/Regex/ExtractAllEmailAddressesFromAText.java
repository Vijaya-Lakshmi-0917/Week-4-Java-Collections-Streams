import java.util.regex.*;
import java.util.*;

class EmailExtractor {

    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String pattern = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = extractEmails(text);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
