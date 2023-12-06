import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedExample {
    private static int count;
    //    Object obj = new Object();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        SynchronizedExample main = new SynchronizedExample();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25000; i++) {
                    main.increment();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 25000; i++) {
                    main.increment();
                }
            }
        });
        thread2.start();
        thread.start();


        try {
            thread.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Count: " + count);

    }

    public void increment() {
        try {
            lock.lock();
            count++;
        } finally {
            lock.unlock();
        }
    }
}
