import static org.junit.Assert.*;
import org.junit.Test;

public class StringUtilityMethodsTest {

    @Test
    public void testReverse() {
        assertEquals("cba", StringUtilityMethods.reverse("abc"));
        assertEquals("", StringUtilityMethods.reverse(""));
        assertEquals("a", StringUtilityMethods.reverse("a"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(StringUtilityMethods.isPalindrome("madam"));
        assertTrue(StringUtilityMethods.isPalindrome("Race car"));
        assertFalse(StringUtilityMethods.isPalindrome("hello"));
        assertTrue(StringUtilityMethods.isPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", StringUtilityMethods.toUpperCase("hello"));
        assertEquals("JAVA", StringUtilityMethods.toUpperCase("Java"));
        assertEquals("", StringUtilityMethods.toUpperCase(""));
    }
}
