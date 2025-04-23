public class StringUtilityMethods {

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
