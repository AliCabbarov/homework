public class Queue {
    private int capacity = 10;
    private int[] arr;
    private int size = 0;

    {
        arr = new int[size];
    }

    public Queue(int capacity) {
        this.capacity = capacity;
    }

    public Queue() {
    }

    public void add(int element) {
        if (size == capacity) {
            growCapacity();
        }

        arr[size++] = element;
    }

    private void growCapacity() {
        int[] tempArr = arr;
        arr = new int[capacity *= 2];

        System.arraycopy(tempArr, 0, arr, 0, tempArr.length);
    }

//    public int pop() {
//
//    }
}
