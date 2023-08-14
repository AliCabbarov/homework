public class DeadLockExample {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("obj1 start");
                synchronized (obj1){
                    System.out.println("obj2 waiting");
                    synchronized (obj2){
//                        System.out.println("thread 1");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("obj2 start");
                synchronized (obj2){
                    System.out.println("obj1 waiting");
                    synchronized (obj1){
//                        System.out.println("thread 2");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

    }

}
