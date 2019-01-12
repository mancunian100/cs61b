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
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
        ad2.addFirst("h");
	    System.out.println(ad2.nextFirst);
    }
}
