package enums;

public enum Supply {
    FOOD(0.2,0.1),
    DRINK(0.3,0.2);
    private final double increaseValue;
    private final double decreaseValue;

    Supply(double increaseValue, double decreaseValue) {
        this.increaseValue = increaseValue;
        this.decreaseValue = decreaseValue;
    }

    public double getIncreaseValue() {
        return increaseValue;
    }

    public double getDecreaseValue() {
        return decreaseValue;
    }
}
