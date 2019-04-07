import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortTester {
    private static String[] unsorted = {"123", "765", "34", "968", "932", "23", "1", "85", "41"};

    @Test
    public void testRadixSort() {
        String[] expected = {"1", "23", "34", "41", "85", "123", "765", "932", "968"};
        Assert.assertArrayEquals(RadixSort.sort(unsorted), expected);
//        System.out.print(RadixSort.sort(unsorted)[0]);
    }
}
