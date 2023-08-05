package proxyPattern;

public class Admin implements User{
    @Override
    public void create() {
        System.out.println("ok!");
    }

    @Override
    public void update() {
        System.out.println("ok!");
    }

    @Override
    public void delete() {
        System.out.println("ok!");
    }

    @Override
    public void read() {
        System.out.println("ok!");
    }
}
