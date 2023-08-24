public class MyDeQueue<E> {
    private static final int INITIAL_CAPACITY = 1;
    private Object[] data;
    private final int first;
    private int last;
    private int currentSize;

    {
        first = 0;
    }

    public MyDeQueue() {
        data = new Object[INITIAL_CAPACITY];
        currentSize = 0;
        last = 0;
    }

    public void addFirst(E element) {
        if (currentSize == 0) {
            data[first] = element;
            currentSize++;
            return;
        }
        if (currentSize > 0) {
            growSizeForAddFirst();
        }
        data[first] = element;
        last++;
    }

    public void addLast(E element) {
        if (currentSize == 0) {
            data[last] = element;
            currentSize++;
            return;
        }

        if (currentSize > 0) {
            growSizeForAddLast();
        }

        data[last += 1] = element;

    }

    public E peekFirst() {
        return (E) data[first];
    }

    public E peekLast() {
        return (E) data[last];
    }

    public E popFirst() {
        return (E) removeAndGetForFirst();
    }

    public E popLast() {
        return (E) removeAndGetForLast();
    }

    private Object removeAndGetForLast() {
        Object lastElement = data[last];
        Object[] tempData = data;
        data = new Object[currentSize -= 1];
        last--;
        for (int i = 0; i < data.length; i++) {
            data[i] = tempData[i];
        }
        return lastElement;
    }

    private Object removeAndGetForFirst() {
        Object firstElement = data[first];
        Object[] tempData = data;
        data = new Object[currentSize -= 1];
        last--;
        for (int i = 0; i < data.length; i++) {
            data[i] = tempData[i + 1];
        }
        return firstElement;
    }

    private void growSizeForAddFirst() {
        Object[] tempData = data;
        data = new Object[currentSize+=1];
        for (int i = 0; i < tempData.length; i++) {
            data[i + 1] = tempData[i];
        }
    }

    private void growSizeForAddLast() {
        Object[] tempData = data;
        data = new Object[currentSize+=1];
        for (int i = 0; i < tempData.length; i++) {
            data[i] = tempData[i];
        }

    }

    public void printList() {
        System.out.print("[ ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("]");
    }
}
