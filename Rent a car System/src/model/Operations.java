package model;

import java.time.LocalDate;

public class Operations {
    private long id;
    private long CarId;
    private String name;
    private String surname;
    private LocalDate birthday;
    private String fin;
    private String passport;
    private boolean isContinuing;

    public Operations(long id,long CarId, String name, String surname, LocalDate birthday, String fin, String passport, boolean isContinuing) {
        this.id = id;
        this.CarId = CarId;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.fin = fin;
        this.passport = passport;
        this.isContinuing = isContinuing;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "id=" + id +
                ", CarId=" + CarId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                ", fin='" + fin + '\'' +
                ", passport='" + passport + '\'' +
                ", isContinuing=" + isContinuing +
                '}';
    }

    public long getCarId() {
        return CarId;
    }

    public void setCarId(long carId) {
        CarId = carId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public boolean isContinuing() {
        return isContinuing;
    }

    public void setContinuing(boolean continuing) {
        isContinuing = continuing;
    }

}
