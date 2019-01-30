package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        /** test initialization and isEmpty(). */
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        Integer[] expected = new Integer[10];
//        assertEquals(expected, arb.getRb());
        assertEquals(true, arb.isEmpty());

        /** test enqueue. */
        arb.enqueue(1);
        expected[0] = 1;
//        assertEquals(expected, arb.getRb());

        /** test peek. */
        Integer actualPeek = arb.peek();
        Integer expectedPeek = 1;
        assertEquals(expectedPeek, actualPeek);

        /** test dequeue. */
        Integer firstEle = arb.dequeue();
        expected = new Integer[10];
        Integer expectedFirstEle = 1;
        assertEquals(expectedFirstEle, firstEle);
//        assertEquals(expected, arb.getRb());

        /** test isFull(). */
        for (int i = 0; i < 10; i += 1) {
            arb.enqueue(i+1);
        }
        expected = new Integer[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        assertEquals(expected, arb.getRb());
        assertTrue(arb.isFull());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
