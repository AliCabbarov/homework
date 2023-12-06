package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Customer {
    private int id;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private double moneyAccount;
    private LocalDateTime reservationDate;
    private LocalDateTime endReservationDate;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private int roomNumber;

    public Customer(int id, String name, String surname, LocalDate birthday, String phoneNumber, String email, String password, double moneyAccount, LocalDateTime reservationDate, LocalDateTime endReservationDate, LocalDateTime registerDate, LocalDateTime updateDate, int roomNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.moneyAccount = moneyAccount;
        this.reservationDate = reservationDate;
        this.endReservationDate = endReservationDate;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
        this.roomNumber = roomNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getEndReservationDate() {
        return endReservationDate;
    }

    public void setEndReservationDate(LocalDateTime endReservationDate) {
        this.endReservationDate = endReservationDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", moneyAccount=" + moneyAccount +
                ", reservationDate=" + reservationDate +
                ", endReservationDate=" + endReservationDate +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
