import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String surname;
    private LocalDate localDate;

    public User(int id, String name, String surname, LocalDate localDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.localDate = localDate;
    }

    public int getId() {
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

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
