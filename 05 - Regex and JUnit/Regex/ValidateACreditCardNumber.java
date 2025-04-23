import java.util.regex.*;

class CreditCardValidator {

    public static boolean isValidCard(String cardNumber) {
        String visaPattern = "^4\\d{15}$";
        String masterPattern = "^5\\d{15}$";
        return Pattern.matches(visaPattern, cardNumber) || Pattern.matches(masterPattern, cardNumber);
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4123456789012345"));
        System.out.println(isValidCard("5123456789012345"));
        System.out.println(isValidCard("6123456789012345"));
        System.out.println(isValidCard("412345678901234"));
        System.out.println(isValidCard("51234567890123456"));
    }
}
