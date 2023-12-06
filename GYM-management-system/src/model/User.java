package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private final long id;
    private String name;
    private String surname;
    private String fin;
    private String serialNumber;
    private int departures;
    private LocalDate expirationDate;
    private double amount;
    private LocalDateTime registerDate;
    private LocalDate updateDate;

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public User(long id, String name, String surname, String fin, String serialNumber, int departures, LocalDate expirationDate, double amount, LocalDateTime registerDate, LocalDate updateDate ) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.serialNumber = serialNumber;
        this.departures = departures;
        this.expirationDate = expirationDate;
        this.amount = amount;
        this.registerDate =registerDate;
        this.updateDate = updateDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getDepartures() {
        return departures;
    }

    public void setDepartures(int departures) {
        this.departures = departures;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fin='" + fin + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", departures=" + departures +
                ", expirationDate=" + expirationDate +
                ", amount=" + amount +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }

    private String getInfo(){
         return "User{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", serialNumber (passport)='" + serialNumber + '\'' +
                ", departures='" + departures + '\'' +
                ", expirationDate=" + expirationDate +
                ", amount=" + amount +
                '}';
    }
}
