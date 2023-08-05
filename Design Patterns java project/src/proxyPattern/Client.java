package proxyPattern;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy("leyla");
        proxy.create();
    }
}
