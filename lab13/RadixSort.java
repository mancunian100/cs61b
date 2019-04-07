/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
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

        String[] sorted = new String[asciis.length];
        System.arraycopy(asciis, 0, sorted, 0, asciis.length);

        // get the maximum length of string in asciis
        int max = 0;
        for (String asc : asciis) {
            max = max > asc.length() ? max : asc.length();
        }

        int index = 0;
        while (index < max) {
            sorted = sortHelperLSD(sorted, index);
            index += 1;
        }

        return sorted;
    }


    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static String[] sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort

        // buckets for inserting number of "digits"
        int[] buckets = new int[256];
        String[] sorted = new String[asciis.length];

        // counting process
        for (String a : asciis) {
            int pos = (int) a.charAt(a.length() - index - 1);
            buckets[pos] += 1;
        }


        // adjust buckets number
        int prev = 0;
        for (int i = 0; i < 256; i++) {
            if (buckets[i] > 0) {
                buckets[i] += prev;
                prev = buckets[i];
            }
        }


        // re-order the asciis array in sorted array
        for (int numString = asciis.length - 1; numString >= 0; numString -= 1) {
            // int number of character at particular position
            int num = (int) asciis[numString].charAt(asciis[numString].length() - index - 1);

            // index of that String in sorted array
            buckets[num] -= 1;
            int pos = buckets[num];

            // move that String to the new array
            sorted[pos] = asciis[numString];

        }

        return sorted;

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
