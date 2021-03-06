/**
 * Created by mancunian100 on 2019/01/15
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {

    /**
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
            assertEquals("addFirst()", a, s);
        }
    }
    */

    // for task 2
    @Test
    public void testWithMsg() {
        StudentArrayDeque stu = new StudentArrayDeque<Integer>();
        ArrayDequeSolution sol = new ArrayDequeSolution<Integer>();

        for (int i = 0; i <= 10; i++) {
            int last = StdRandom.uniform(11, 20);

            stu.addLast(last);
            sol.addLast(last);

        }

        String msg = helper1(sol);
        for (int i = 0; i <= 10; i++) {

            Object expected = sol.removeLast();
            Object actual = stu.removeLast();

            assertEquals(helper(i, msg), expected, actual);
        }


    }

    private String helper1(ArrayDequeSolution<Integer> ads) {
        String newMsg;
        String res = "Oh noooo!\n   This is bad:\n   Related Operation:\n";

        for(int i = 0; i<10; i++) {
            newMsg = "   addLast(" + ads.get(i) + ");\n";
            res += newMsg;
        }

        return res;
    }

    private String helper(int len, String msg) {

        for (int i = 0; i<len; i++) {
            msg += "   removeLast();\n";
        }
        return msg;
    }

}
