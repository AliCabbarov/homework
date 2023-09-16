public class SingleTreadPool implements Runnable {
    String exp = "";

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            exp += "a";
        }
    }

}
