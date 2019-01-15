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
        char b1 = 'G';
        char a2 = '&';
        char b2 = '%';
        char a3 = 'c';
        char b3 = 'd';
        boolean actual1 = offByOne.equalChars(a1, b1);
        boolean actual2 = offByOne.equalChars(a2, b2);
        boolean actual3 = offByOne.equalChars(a3, b3);
        boolean expected1 = true;
        boolean expected2 = true;
        boolean expected3 = true;
        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
//    Uncomment this class once you've created your
//    CharacterComparator interface and OffByOne class.
}
