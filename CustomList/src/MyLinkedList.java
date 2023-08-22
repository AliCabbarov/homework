public class MyLinkedList<E> {
    private Node<E> head;
    private int size;

    public void add(E element) {
        Node<E> node = new Node<>(element);
        if (head == null) {
            head = node;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        ++size;

    }

    public void printLInkedList() {
        if (head == null) {
            throw new RuntimeException("Element has not exist!!!");
        }
        Node<E> current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.data;
    }

    public void remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> node = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            node.next = node.next.next;
        }
    }

    public static class Node<E> {
        E data;
        Node<E> next;

        private Node(E element) {
            this.data = element;
            this.next = null;
        }
    }
}
