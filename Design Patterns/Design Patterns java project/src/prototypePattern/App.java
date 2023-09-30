package prototypePattern;

public class App {
    public static void main(String[] args) {

        //Original prototype created...
        ConcretePrototype original = new ConcretePrototype("original Prototype!!!");
        //Copy prototype created...
        ConcretePrototype copy = (ConcretePrototype) original.clone();
        copy.setProperty("Copy Prototype!!");

        System.out.println("original prototype: " + original.getProperty());
        System.out.println("copy prototype    : " + copy.getProperty());
    }
}
