package strategyPattern;
// Concrete Strategy 2
class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with PayPal using email: " + email);
    }
}
