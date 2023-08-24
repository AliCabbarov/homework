import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println("-------------------------");
        MyDeQueue<Integer> deQueue =  new MyDeQueue<>();
        deQueue.addFirst(1);
        deQueue.addLast(6);
        deQueue.addLast(5);
        deQueue.addFirst(3);
        deQueue.addLast(2);
        deQueue.addFirst(1);
        deQueue.addLast(9);
        deQueue.addLast(8);
        deQueue.addFirst(10);
        deQueue.addFirst(118);
        deQueue.addLast(16);
        deQueue.addFirst(15);
        System.out.println(deQueue.peekFirst());
        System.out.println(deQueue.peekLast());
        deQueue.printList();

        System.out.println(deQueue.popFirst());
        System.out.println(deQueue.popFirst());
        System.out.println(deQueue.popLast());
        System.out.println(deQueue.popFirst());
        deQueue.printList();


    }
}