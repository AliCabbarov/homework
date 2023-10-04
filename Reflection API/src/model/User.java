package model;

public class User {
    private int id;
    private String name;
    @Test
    private String surname;
    private int age;

    public User() {
    }

    public int getId() {
        return id;
    }

    @Test
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
