package synthesizer;
//import synthesizer.AbstractBoundedQueue;

//import java.security.cert.TrustAnchor;
import java.util.Iterator;
//import java.util.TreeMap;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
    }

    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<T> {
        private int p;

        KeyIterator() {
            p = 0;
        }

        public boolean hasNext() {
            return p < fillCount;
        }

        public T next() {
            T returnVal = rb[p];
            p += 1;
            return returnVal;
        }
    }

    /**
     * Helper method to get the private array rb.
     */
//    T[] getRb() {
//        return rb;
//    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last += 1;
        if (last >= rb.length) {
            last -= rb.length;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T firstElement = rb[first];
        rb[first] = null;
        fillCount -= 1;
        first += 1;
        if (first >= rb.length) {
            first -= rb.length;
        }
        return firstElement;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T peek = rb[first];
        return peek;
    }

}
