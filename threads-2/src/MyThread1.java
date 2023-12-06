public class MyThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 50; i < 100; i++) {
            System.out.println(i);
        }
    }
}
