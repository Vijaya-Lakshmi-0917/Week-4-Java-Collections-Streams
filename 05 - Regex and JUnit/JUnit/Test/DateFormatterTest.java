import static org.junit.Assert.*;
import org.junit.Test;
import java.text.ParseException;

public class DateFormatterTest {

    @Test
    public void testValidDate() throws ParseException {
        assertEquals("21-05-2025", DateFormatter.formatDate("2025-05-21"));
    }

    @Test(expected = ParseException.class)
    public void testInvalidDateFormat() throws ParseException {
        DateFormatter.formatDate("21/05/2025");
    }

    @Test(expected = ParseException.class)
    public void testInvalidDateValue() throws ParseException {
        DateFormatter.formatDate("2025-02-30"); // invalid day
    }

    @Test(expected = ParseException.class)
    public void testEmptyDate() throws ParseException {
        DateFormatter.formatDate("");
    }

    @Test(expected = ParseException.class)
    public void testNullDate() throws ParseException {
        DateFormatter.formatDate(null);
    }
}
