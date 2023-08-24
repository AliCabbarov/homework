import java.util.Arrays;

public class MyStack<E> {
    private final static int INITIAL_CAPACITY = 10;
    private Object[] data;
    private int last;
    private int capacity;

    {
        last = -1;
    }

    public MyStack(int initialCapacity) {
        data = new Object[initialCapacity];
        capacity = initialCapacity;
    }

    public MyStack() {
        data = new Object[INITIAL_CAPACITY];
        capacity = INITIAL_CAPACITY;
    }

    public void push(E element) {
        if (last == capacity - 1) {
            growSize();
        }
        data[++last] = element;
    }

    private void growSize() {
        data = Arrays.copyOf(data, capacity = last + 1);
    }

    public Object peek() {
        if (last < 0) {
            throw new NullPointerException();
        }
        return data[last];
    }

    public Object pop() {
        if (last < 0) {
            throw new NullPointerException();
        }
        return getAndRemove();

    }

    private Object getAndRemove() {
        Object lastElement = data[last];
        data = Arrays.copyOf(data, capacity -= 1);
        last--;

        return lastElement;
    }
}
