import java.util.regex.*;

class HexColorValidator {

    public static boolean isValidHexColor(String color) {
        String pattern = "^#[0-9A-Fa-f]{6}$";
        return Pattern.matches(pattern, color);
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
        System.out.println(isValidHexColor("FFA500"));
        System.out.println(isValidHexColor("#GGGGGG"));
    }
}