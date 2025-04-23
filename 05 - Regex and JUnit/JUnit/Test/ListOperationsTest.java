import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ListOperationsTest {

    private ListOperations manager;
    private List<Integer> list;

    @Before
    public void setUp() {
        manager = new ListOperations();
        list = new ArrayList<>();
    }

    @Test
    public void testAddElement() {
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
        assertEquals(1, list.size());
    }

    @Test
    public void testRemoveElement() {
        list.add(10);
        list.add(20);
        manager.removeElement(list, 10);
        assertFalse(list.contains(10));
        assertEquals(1, list.size());
    }

    @Test
    public void testGetSize() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, manager.getSize(list));
        manager.removeElement(list, 2);
        assertEquals(2, manager.getSize(list));
    }
}
