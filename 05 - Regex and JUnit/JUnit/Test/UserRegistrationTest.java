import static org.junit.Assert.*;
import org.junit.Test;

public class UserRegistrationTest {

    @Test
    public void testValidRegistration() {
        UserRegistration.registerUser("john_doe", "john@example.com", "secure123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyUsername() {
        UserRegistration.registerUser("", "john@example.com", "secure123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidEmail() {
        UserRegistration.registerUser("john_doe", "johnexample.com", "secure123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShortPassword() {
        UserRegistration.registerUser("john_doe", "john@example.com", "123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUsername() {
        UserRegistration.registerUser(null, "john@example.com", "secure123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullEmail() {
        UserRegistration.registerUser("john_doe", null, "secure123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassword() {
        UserRegistration.registerUser("john_doe", "john@example.com", null);
    }
}
