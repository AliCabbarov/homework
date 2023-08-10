package model;

public class Character {
    private String username;
    private double healthStatus;
    private double weight;

    public Character(String username) {
        this.username = username;
        this.healthStatus = 100;
        this.weight = 70;
    }

    @Override
    public String toString() {
        return "Character{" +
                "username='" + username + '\'' +
                ", healthStatus=" + healthStatus +
                ", weight=" + weight +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(double healthStatus) {
        this.healthStatus = healthStatus;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
