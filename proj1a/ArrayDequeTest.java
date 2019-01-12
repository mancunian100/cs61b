/** Performs some basic array list tests. */

import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayDequeTest {

    /** test add, size and get. */
    @Test
    public void testAddGet() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addFirst("Hello");
        assertEquals("Hello", ad1.get(0));
        assertEquals(1, ad1.size());
    }

    /** test remove. */
    @Test
    public void testRemove() {
        ArrayDeque<String> ad1 = new ArrayDeque<>();
        ad1.addLast("H");
        ad1.printDeque();
        ad1.removeFirst();
        assertEquals(0, ad1.size());
        ad1.addFirst("o");
        assertEquals("o", ad1.get(0));
        ad1.removeLast();
        assertEquals(true, ad1.isEmpty());
    }

    /** test resize. */
    @Test
    public void testResize() {
        ArrayDeque<String> ad2 = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            ad2.addFirst("h");
        }
        assertEquals(8, ad2.size());
        assertEquals("h", ad2.get(7));
        for (int i = 0; i < 8; i++) {
            ad2.removeLast();
        }
        assertEquals(0, ad2.size());
        assertEquals(null, ad2.get(7));
        for (int i = 0; i < 8; i++) {
            ad2.addFirst("h");
        }
        assertEquals(8, ad2.size());
        assertEquals("h", ad2.get(7));
    }

    /** test removeFirst. */
    @Test
    public void testRemoveFirst() {
        ArrayDeque<String> ad3 = new ArrayDeque<>();
        for (int i = 0; i < 33; i++) {
            ad3.addLast("h");
        }
//        ad3.printDeque();
        for (int i = 0; i < 33; i++) {
            ad3.removeLast();
        }
        ad3.printDeque();
        assertEquals(true, ad3.isEmpty());
    }
}
