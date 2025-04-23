import static org.junit.Assert.*;
import org.junit.Test;

public class ExceptionHandlingTest {

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        ExceptionHandling.divide(10, 0);
    }

    @Test
    public void testDivideNormal() {
        assertEquals(5, ExceptionHandling.divide(10, 2));
    }
}
