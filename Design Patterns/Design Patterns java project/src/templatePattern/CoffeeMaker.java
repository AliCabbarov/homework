package templatePattern;

// Abstract CoffeeMaker class (Abstract Template)
abstract class CoffeeMaker {
    // Template method: defines the algorithm
    public final void makeCoffee() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void brewCoffeeGrinds();
    protected abstract void addCondiments();

    // Concrete methods
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
