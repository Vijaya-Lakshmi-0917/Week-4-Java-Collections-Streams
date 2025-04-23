import static org.junit.Assert.*;
import org.junit.Test;

public class PerformanceTestingTest {

    @Test(timeout = 2000)
    public void testPerformanceTestingTimeout() throws InterruptedException {
        String result = PerformanceTesting.longRunningTask();
        assertEquals("Completed", result);
    }
}