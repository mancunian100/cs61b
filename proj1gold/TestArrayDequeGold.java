/**
 * Created by mancunian100 on 2019/01/15
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ad1 = new ArrayDequeSolution<>();

        for (Integer i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne > 0.5) {
                sad1.addFirst(i);
                ad1.addFirst(i);
            } else {
                sad1.addLast(i);
                ad1.addLast(i);
            }
        }

        for (Integer i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            Integer s;
            Integer a;
            if (numberBetweenZeroAndOne > 0.5) {
                s = sad1.removeFirst();
                a = ad1.removeFirst();
            } else {
                s = sad1.removeLast();
                a = ad1.removeLast();
            }
            assertEquals("removeFirst()", a, s);
        }
    }

}
