import static org.junit.Assert.*;
import org.junit.Test;

public class PassWordStrengthValidatorTest {

    @Test
    public void testValidPassword() {
        assertTrue(PassWordStrengthValidator.isValid("Password1"));
    }

    @Test
    public void testTooShortPassword() {
        assertFalse(PassWordStrengthValidator.isValid("Pass1"));
    }

    @Test
    public void testNoUppercasePassword() {
        assertFalse(PassWordStrengthValidator.isValid("password1"));
    }

    @Test
    public void testNoDigitPassword() {
        assertFalse(PassWordStrengthValidator.isValid("Password"));
    }

    @Test
    public void testNullPassword() {
        assertFalse(PassWordStrengthValidator.isValid(null));
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(PassWordStrengthValidator.isValid(""));
    }
}
