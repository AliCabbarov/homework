package templatePattern;

public class App {
    public static void main(String[] args) {
        CoffeeMaker coffee1 = new Coffee1();
        CoffeeMaker coffee2 = new Coffee2();

        System.out.println("Preparing Coffee 1:");
        coffee1.makeCoffee();

        System.out.println("\nPreparing Coffee 2:");
        coffee2.makeCoffee();
    }
}
