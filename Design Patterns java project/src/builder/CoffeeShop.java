package builder;

public class CoffeeShop {
    private String coffee;
    private int size;
    private boolean milk;
    private boolean sugar;


    private CoffeeShop(CoffeeShopBuilder coffeeShopBuilder) {
        this.coffee = coffeeShopBuilder.coffee;
        this.size = coffeeShopBuilder.size;
        this.milk = coffeeShopBuilder.milk;
        this.sugar = coffeeShopBuilder.sugar;
    }

    public static class CoffeeShopBuilder{
        private String coffee;
        private int size;
        private boolean milk;
        private boolean sugar;

        public CoffeeShopBuilder(String coffee) {
            this.coffee = coffee;
            size=2;
        }

        public CoffeeShopBuilder Size(int size) {
            this.size = size;
            return this;
        }

        public CoffeeShopBuilder Milk(boolean milk) {
            this.milk = milk;
            return this;
        }

        public CoffeeShopBuilder Sugar(boolean sugar) {
            this.sugar = sugar;
            return this;
        }

        public CoffeeShop build(){
            return new CoffeeShop(this);
        }

    }

    @Override
    public String toString() {
        return "CoffeeShop{" +
                "coffee='" + coffee + '\'' +
                ", size=" + size +
                ", milk=" + milk +
                ", sugar=" + sugar +
                '}';
    }
}
