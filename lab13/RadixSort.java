/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */

import java.util.Queue;
import java.util.LinkedList;

public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
//    public static String[] sort(String[] asciis) {
//        int len = 0;
//        for (String str : asciis) {
//            int l = str.length();
//            len = l > len ? l : len;
//        }
//        String[] sorted = new String[asciis.length];
//        System.arraycopy(asciis, 0, sorted, 0, asciis.length);
//        sortHelperLSD(sorted, len);
//        return sorted;
//    }
//
//    /**
//     * LSD helper method that performs a destructive counting sort the array of
//     * Strings based off characters at a specific index.
//     * @param asciis Input array of Strings
//     * @param index The position to sort the Strings on.
//     */
//    private static void sortHelperLSD(String[] asciis, int index) {
//        // Optional LSD helper method for required LSD radix sort
//        if (index == 0) {
//            return;
//        }
//        int[] counts = new int[256];
//        String[] unsorted = new String[asciis.length];
//        System.arraycopy(asciis, 0, unsorted, 0, asciis.length);
////        String[] sorted = new String[asciis.length];
//        int len = 0;
//        for (String str : unsorted) {
//            int l = str.length();
//            len = l > len ? l : len;
//        }
//        for (String str : unsorted) {
//            int at = index - (len - str.length()) - 1;
//            int label;
//            if (at < 0) {
//                label = 0;
//            } else {
//                label = (int) str.charAt(at);
//            }
//            counts[label] += 1;
//        }
//        for (int i = 1; i < counts.length; i += 1) {
//            counts[i] += counts[i - 1];
//        }
//        for (int i = unsorted.length - 1; i >= 0; i -= 1) {
//            String str = unsorted[i];
//            int at = index - (len - str.length()) - 1;
//            int label;
//            if (at < 0) {
//                label = 0;
//            } else {
//                label = (int) str.charAt(at);
//            }
//            counts[label] -= 1;
//            int place = counts[label];
//            asciis[place] = str;
//        }
//        sortHelperLSD(asciis, index - 1);
//    }

    public static String[] sort(String[] asciis) {
        Queue<String>[] buckets = new Queue[256];
        for (int i = 0; i < 256; i++)
            buckets[i] = new LinkedList();

        boolean sorted = false;
        int lengthInc = 0;

        String[] sortedArr = new String[asciis.length];
        System.arraycopy(asciis, 0, sortedArr, 0, asciis.length);

        while (!sorted) {
            sorted = true;

            for (String item : sortedArr) {
                int index = item.length() - lengthInc - 1;
                if (index >= 0) {
                    sorted = false;
                    int ofASCII = (int) item.charAt(index);
                    buckets[ofASCII].add(item);
                } else {
                    buckets[(int) item.charAt(0)].add(item);
                }


            }

            lengthInc++;
            int index = 0;

            for (Queue<String> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    sortedArr[index] = bucket.remove();
                    index++;
                }
            }

            //System.out.println();

        }

        //System.out.println("");

        return sortedArr;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
