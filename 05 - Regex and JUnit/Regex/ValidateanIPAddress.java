import java.util.regex.*;

class IPAddressValidator {

    public static boolean isValidIP(String ip) {
        String num = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        String pattern = "^(" + num + "\\.){3}" + num + "$";
        return Pattern.matches(pattern, ip);
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));    // true
        System.out.println(isValidIP("255.255.255.255")); // true
        System.out.println(isValidIP("256.100.0.1"));     // false
        System.out.println(isValidIP("192.168.1"));       // false
        System.out.println(isValidIP("192.168.01.1"));    // true (leading zero allowed here)
    }
}