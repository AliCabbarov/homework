package builder;

public class App {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop.CoffeeShopBuilder("Americano")
                .Size(3)
                .Sugar(true)
                .Milk(true)
                .build();

        System.out.println(coffeeShop.toString());

    }
}
