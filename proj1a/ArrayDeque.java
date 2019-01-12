/** the array deque implemented in circular way.
 * @author mancunian100
 */

public class ArrayDeque<T> {
    /** an array to storage items. */
    private T[] items;
    /** the size of array. */
    private int size;
    /** the pointer of the new first Item. */
    private int nextFirst;
    /** the pointer of the new last Item. */
    private int nextLast;

    /** create an empty item array. */
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }
    /** a helper method to resize the array to new storage size S. */
    /** there some bugs in it, need to be fixed */
    private void resize(int s) {
        T [] newItems = (T []) new Object[s];
        int l = newItems.length;
        if (nextFirst >= l) {
            nextFirst -= l;
        }
        for (int i = 0; i < size; i++) {
            if (nextFirst + 1 + i >= l) {
                newItems[nextFirst + 1 + i - l] = items[nextFirst + 1 + i];
            } else {
                newItems[nextFirst + 1 + i] = items[nextFirst + 1 + i];
            }
        }
        items = newItems;
    }

    /** add an Item I at the front of the array.
     *
     * Args: I, the new first Item
     * Return: nothing
     */
    public void addFirst(T i) {
        if (size == items.length) {
            resize(size * 2);
        }
        size += 1;
        items[nextFirst] = i;
        nextFirst -= 1;
        if (nextFirst < 0) {
            nextFirst += items.length;
        }
    }

    /** add an Item I at the end of the array.
     * Args: I, the new last Item
     * Returns: nothing
     */
    public void addLast(T i) {
        if (size == items.length) {
            resize(size * 2);
        }
        size += 1;
        items[nextLast] = i;
        nextLast += 1;
        if (nextLast >= items.length) {
            nextLast -= items.length;
        }
    }

    /** determine whether the array is empty.
     * Args: nothing
     * Returns: true if the LinkedList is empty */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** return the size if the array.
     * Args: nothing
     * Returns: size, the size number of the array */
    public int size() {
        return size;
    }

    /** print all the Items in the array, separated by a space. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int index = i + nextFirst;
            if (index >= items.length) {
                index -= items.length;
            }
            System.out.print(items[index] + " ");
        }
    }

    /** remove the first Item of the array, if not exists return null.
     * Args: nothing
     * Returns: I, the first Item of the array */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        if (size < 0.25 * items.length) {
            resize((int) (items.length * 0.5));
        }
        T oldFirst = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        return oldFirst;
    }

    /** remove the last Item of the array, if not exists return null.
     * Args: nothing
     * Returns: I, the last Item of the array */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        if (size < 0.25 * items.length) {
            resize((int) (items.length * 0.5));
        }
        T oldLast = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        return oldLast;
    }

    /** get the ith Item of the array, if not exists return null.
     * Args: I (int), the index of the Item need to get
     * Returns: item (Item), the ith Item we get */
    public T get(int i) {
        if (i >= size) {
            return null;
        }
        int index = nextFirst + 1 + 1;
        if (index >= items.length) {
            index -= items.length;
        }
        return items[index];
    }
}
