import static org.junit.Assert.*;
        import org.junit.*;

public class BeforeEachAndAfterEachAnnotationsTest {

    private BeforeEachAndAfterEachAnnotations db;

    @Before
    public void setUp() {
        db = new BeforeEachAndAfterEachAnnotations();
        db.connect();
    }

    @After
    public void tearDown() {
        db.disconnect();
    }

    @Test
    public void testConnectionIsEstablished() {
        assertTrue(db.isConnected());
    }

    @Test
    public void testConnectionIsClosedAfterTest() {
        db.disconnect();
        assertFalse(db.isConnected());
    }
}