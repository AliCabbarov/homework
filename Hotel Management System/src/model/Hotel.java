package model;

public class Hotel {
    private final int id;
    private final String name;
    private final String location;
    private double bankAccount;
    private final byte star;

    public Hotel(int id, String name, String location, double bankAccount, byte star) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.bankAccount = bankAccount;
        this.star = star;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(double bankAccount) {
        this.bankAccount = bankAccount;
    }

    public byte getStar() {
        return star;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", bankAccount=" + bankAccount +
                ", star=" + star +
                '}';
    }
}
