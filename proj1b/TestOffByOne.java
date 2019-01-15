import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOffByOne() {
        char a1 = 'F';
        char b1 = 'g';
        char a2 = '&';
        char b2 = '%';
        char a3 = 'c';
        char b3 = 'd';
        char a4 = 'c';
        char b4 = 'x';
        boolean actual1 = offByOne.equalChars(a1, b1);
        boolean actual2 = offByOne.equalChars(a2, b2);
        boolean actual3 = offByOne.equalChars(a3, b3);
        boolean actual4 = offByOne.equalChars(a4, b4);
        boolean expected1 = false;
        boolean expected2 = true;
        boolean expected3 = true;
        boolean expected4 = false;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
        assertEquals(expected4, actual4);
    }
//    Uncomment this class once you've created your
//    CharacterComparator interface and OffByOne class.
}
