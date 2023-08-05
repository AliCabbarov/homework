package Model;

public class Book {
    private static int autoIncrement = 1;
    private Integer id;
    private String name;
    private String description;
    private Author author;

    public Book(String name, String description, Author author) {
        this.id = autoIncrement++;
        this.name = name;
        this.description = description;
        this.author = author;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


    public static int getAutoIncrement(){
        return autoIncrement;
    }

    public String getInfo() {
        return "id:" + id +
                "\nname: " + name +
                "\ndescription: " + description +
                "\nAuthor name: " + author.name;
    }
}
