import java.util.regex.*;

class SSNValidator {

    public static boolean isValidSSN(String ssn) {
        String pattern = "^\\d{3}-\\d{2}-\\d{4}$";
        return Pattern.matches(pattern, ssn);
    }

    public static void main(String[] args) {
        System.out.println(isValidSSN("123-45-6789"));
        System.out.println(isValidSSN("123456789"));
    }
}
