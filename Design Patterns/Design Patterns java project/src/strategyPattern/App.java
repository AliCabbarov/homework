package strategyPattern;

public class App {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Credit Card Payment
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        cart.checkout(100);

        // PayPal Payment
        cart.setPaymentStrategy(new PayPalPayment("example@example.com"));
        cart.checkout(50);
    }
}
