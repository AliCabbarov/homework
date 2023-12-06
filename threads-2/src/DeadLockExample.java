public class DeadLockExample {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-1: initialize");
                synchronized (lock1) {
                    System.out.println("Thread-1: waiting for - " + lock2);
                    synchronized (lock2) {
                        System.out.println("Thread-1");
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread-2: intialize");
                synchronized (lock2) {
                    System.out.println("Thread-2: waiting for - " + lock1);
                    synchronized (lock1) {
                        System.out.println("Thread-1");
                    }
                }
            }
        });

        thread.start();
        thread2.start();
    }
}
