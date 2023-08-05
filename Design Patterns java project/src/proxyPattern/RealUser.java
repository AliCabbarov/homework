package proxyPattern;

public class RealUser implements User{
    @Override
    public void create() {
        System.out.println("Error!");
    }

    @Override
    public void update() {
        System.out.println("Error!");
    }

    @Override
    public void delete() {
        System.out.println("Error!");
    }

    @Override
    public void read() {
        System.out.println("ok!");
    }
}
