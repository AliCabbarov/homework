import java.util.Scanner;

public class NotifyAndWaitExample {
    static final Object obj = new Object();
    static final Object obj1 = new Object();

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 starting..");
                try {
                    synchronized (obj1) {
                        obj1.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1 continue..");
            }
        });



        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("thread 2 starting..");
                System.out.print("you should press enter ");
                scanner.nextLine();
                synchronized (obj1) {
                    try {
                        obj1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread 2 continue..");

            }
        });


        thread.start();
        thread2.start();
    }
}
