import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RadixSortTester {
    private static String[] unsorted = {"ù", " ", "<"};

    @Test
    public void testRadixSort() {
        String[] expected = {"<", " ", "ù"};
//        Assert.assertArrayEquals(RadixSort.sort(unsorted), expected);
        System.out.print(RadixSort.sort(unsorted)[1]);
    }
}
