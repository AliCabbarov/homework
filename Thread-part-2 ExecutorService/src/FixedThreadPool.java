public class FixedThreadPool implements Runnable{
    public static int count = 0;
    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            count++;
        }
    }
}
