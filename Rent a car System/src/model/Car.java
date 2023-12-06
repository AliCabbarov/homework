package model;

public class Car {
    private long id;
    private String brand;
    private String model;
    private double engine;
    private int production;
    private String bodyType;
    private byte seats;
    private  byte doors;
    private int speed;
    private double amount;
    private boolean isRent;

    public Car(long id, String brand, String model, double engine, int production, String bodyType, byte seats, byte doors, int speed, double amount, boolean isRent) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.production = production;
        this.bodyType = bodyType;
        this.seats = seats;
        this.doors = doors;
        this.speed = speed;
        this.amount = amount;
        this.isRent = isRent;
    }

    public long getId() {
        return id;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(short production) {
        this.production = production;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public byte getSeats() {
        return seats;
    }

    public void setSeats(byte seats) {
        this.seats = seats;
    }

    public byte getDoors() {
        return doors;
    }

    public void setDoors(byte doors) {
        this.doors = doors;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(short speed) {
        this.speed = speed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", production=" + production +
                ", bodyType='" + bodyType + '\'' +
                ", seats=" + seats +
                ", doors=" + doors +
                ", speed=" + speed +
                ", amount=" + amount +
                ", isRent=" + isRent +
                '}';
    }

    public String getInfo() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                ", production=" + production +
                ", bodyType='" + bodyType + '\'' +
                ", seats=" + seats +
                ", doors=" + doors +
                ", speed=" + speed +
                ", amount=" + amount +
                '}';
    }

}
