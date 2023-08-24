public class MyQueue<E> {
    private static final int INITIAL_CAPACITY = 1;
    private Object[] data;
    private final int first;
    private int capacity;
    private int currentSize;

    public MyQueue() {
        data = new Object[INITIAL_CAPACITY];
        first = 0;
        capacity = INITIAL_CAPACITY;
    }

    public void add(E element) {
        if (currentSize != 0) {
            growSize();
        }
        data[currentSize++] = element;
    }

    private void growSize() {
        Object[] tempData = data;
        data = new Object[capacity += 1];
        for (int i = 0; i < tempData.length; i++) {
            data[i] = tempData[i];
        }
    }

    public E peek() {
        if (currentSize == 0) {
            throw new NullPointerException();
        }
        return (E) data[first];
    }

    public E pop() {
        if (currentSize == 0) {
            throw new NullPointerException();
        }
        return (E) removeAndGet();
    }

    private Object removeAndGet() {
        Object firstElement = data[first];
        Object[] tempData = data;
        data = new Object[capacity -= 1];
        for (int i = 0; i < data.length; i++) {
            data[i] = tempData[i + 1];
        }
        return firstElement;
    }

    public void printList() {
        System.out.print("[ ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("]");
    }
}
