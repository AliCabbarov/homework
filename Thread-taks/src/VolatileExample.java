public class VolatileExample extends Thread{
    public static boolean isTrue;



    @Override
    public void run() {
        while (!isTrue){
            System.out.println("Hello World");
        }
    }
}
