import java.io.IOException;

public class ThrowingAndHandlingCheckedAndUnchecked {

    public static void processData(int data) throws IOException {
        if (data < 0) {
            throw new IOException("Negative data not allowed");
        }
        if (data == 0) {
            throw new ArithmeticException("Division by zero");
        }
        int result = 100 / data;
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        try {
            processData(0);
        } catch (IOException e) {
            System.err.println("Checked Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.err.println("Unchecked Exception: " + e.getMessage());
        }
    }
}
