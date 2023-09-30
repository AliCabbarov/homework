package templatePattern;
// Concrete subclass 1
class Coffee1 extends CoffeeMaker {
    @Override
    protected void brewCoffeeGrinds() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
