package model;

public class Character {
    private double healthStatus;
    private String name;

    public Character(String name) {
        this.healthStatus = 100.0;
        this.name = name;
    }

    public double getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(double healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "model.Character{" +
                "healthStatus=" + healthStatus +
                ", name='" + name + '\'' +
                '}';
    }
}
