import java.util.regex.*;

class LicensePlateValidator {

    public static boolean isValidPlate(String plate) {
        String pattern = "^[A-Z]{2}[0-9]{4}$";
        return Pattern.matches(pattern, plate);
    }

    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234"));
        System.out.println(isValidPlate("A12345"));
        System.out.println(isValidPlate("ab1234"));
        System.out.println(isValidPlate("ABC123"));
        System.out.println(isValidPlate("XY0000"));
    }
}
