package synthesizer;

/**
 * Created by mancunian100.
 */

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {

    protected int capacity;
    protected int fillCount;
    /** return the size of the buffer. */
    public int capacity() {
        return capacity;
    };
    /** return number of items currently in the buffer. */
    public int fillCount() {
        return fillCount;
    };


}
