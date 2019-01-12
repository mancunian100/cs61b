/** the Linked List Deque.
 *
 * @author mancunian100
 */

public class LinkedListDeque<T> {

    /**
     * nested Item list class ItemNode.
     */
    private class ItemNode {
        /**
         * the Item of a ItemNode.
         */
        private T item;
        /**
         * the previous ItemNode.
         */
        private ItemNode prev;
        /**
         * the next ItemNode.
         */
        private ItemNode next;

        /**
         * a ItemNode with a Item I, previous ItemNode P and next ItemNode N.
         */
        private ItemNode(T i, ItemNode p, ItemNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /**
     * sentinel ItemNode.
     */
    private ItemNode sentinel;
    /**
     * the LinkedListDeque size number.
     */
    private int size;

//    /**
//     * create an List with one ItemNode with input Item I,
//     * previous ItemNode P and next ItemNode N.
//     */
//    public LinkedListDeque(Item i, ItemNode p, ItemNode n) {
//        sentinel = new ItemNode(null, p, n);
//    }

    /**
     * create an empty ItemNode.
     */
    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * add an Item at the front of the list.
     * Args: I, the new first Item
     * Returns: nothing
     */
    public void addFirst(T i) {
        sentinel.next = new ItemNode(i, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /**
     * add an Item at the end of the list.
     * Args: I, the new last Item
     * Returns: nothing
     */
    public void addLast(T i) {
        sentinel.prev = new ItemNode(i, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /**
     * determine whether the LinkedList is empty.
     * Args: nothing
     * Returns: true if the LinkedList is empty
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * return the size if the LinkedList.
     * Args: nothing
     * Returns: size, the size number of the LinkedList
     */
    public int size() {
        return this.size;
    }

    /**
     * print all the Items in the LinkedList, separated by a space.
     */
    public void printDeque() {
        ItemNode p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            System.out.print(p.item + " ");
        }
    }

    /**
     * remove the first Item of the LinkedList, if not exists return null.
     * Args: nothing
     * Returns: I, the first Item of the LinkedList
     */
    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            T firstItem = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return firstItem;
        }
    }

    /**
     * remove the last Item of the LinkedList, if not exists return null.
     * Args: nothing
     * Returns: I, the last Item of the LinkedList
     */
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            T lastItem = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return lastItem;
        }
    }

    /**
     * get the ith Item of the LinkedList, if not exists return null.
     * Args: I (int), the index of the Item need to get
     * Returns: item (Item), the ith Item we get
     */
    public T get(int i) {
        if (i >= size) {
            return null;
        } else {
            ItemNode p = sentinel.next;
            int pIndex = 0;
            while (pIndex != i) {
                p = p.next;
                pIndex += 1;
            }
            return p.item;
        }
    }

    /**
     * get the ith Item of the LinkedList using recursion, if not exists return null.
     * Args: I (int), the index of the Item need to get
     * Returns: item (Item), the ith Item we get
     */
    public T getRecursive(int i) {
        if (i >= size) {
            return null;
        } else {
            int count = i;
            return recursive(sentinel, i);
        }
    }

    /**
     * a helper method for the getRecursion.
     * Args: I, input ItemNode, C, counter
     * Returns: ItemNode, output ItemNode, C, counter
     */
    public T recursive(ItemNode i, int count) {
        if (count == 0) {
            return i.next.item;
        } else {
            return recursive(i.next, count - 1);
        }
    }
}
