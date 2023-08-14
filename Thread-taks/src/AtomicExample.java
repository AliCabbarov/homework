import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicExample {
    private static AtomicBoolean aBoolean = new AtomicBoolean(false);
    static int count;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!aBoolean.get()){
                    count++;
                }
            }
        });
        thread.start();

        Thread.sleep(2000);
        aBoolean.set(true);
    }

}
