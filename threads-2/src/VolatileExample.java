import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExample {
    private static AtomicBoolean isStopped = new AtomicBoolean(false);

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;

                while (!isStopped.get()) {
                    i++;
                }
                System.out.println(i);

            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isStopped.set(true);
        System.out.println("asfasfa");
    }


}
