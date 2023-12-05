package az.DivAcademy.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {
    @Setter
    long id;
    @Setter
    String title;
    @Setter
    String author;
    @Setter
    String genre;
    @ToString.Exclude
    int copiesCount;
    List<String> comments;
    @Setter
    int likes;
    @Setter
    int dislikes;
    @Setter
    @ToString.Exclude
    double price;
    public void addComments(String comment) {
        this.comments.add(comment);
    }
    public void incrementLikes() {

        likes++;
        dislikes--;
    }
    public void incrementDisLikes() {
        dislikes++;
        likes--;
    }
    public void incrementCopiesCount(){
        copiesCount++;
    }
    public void decrementCopiesCount(){
        copiesCount--;
    }
}
