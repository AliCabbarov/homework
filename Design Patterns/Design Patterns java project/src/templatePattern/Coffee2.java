package templatePattern;

// Concrete subclass 2
class Coffee2 extends CoffeeMaker {
    @Override
    protected void brewCoffeeGrinds() {
        System.out.println("Brewing Espresso");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Steamed Milk");
    }
}
