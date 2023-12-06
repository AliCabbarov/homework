package enums;

public enum Supply {
    WATER(0.15, 0.1),
    FOOD(0.12, 0.1);

    private final double incrementValue;
    private final double decreaseValue;

    Supply(double incrementValue, double decreaseValue) {
        this.incrementValue = incrementValue;
        this.decreaseValue = decreaseValue;
    }

    public double getIncrementValue() {
        return incrementValue;
    }

    public double getDecreaseValue() {
        return decreaseValue;
    }
}
