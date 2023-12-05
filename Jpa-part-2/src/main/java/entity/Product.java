package entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
//    private BigDecimal amount;
//    @ElementCollection
//    private List<String> comment;
    private int like;
//    private byte star;
//    private int remainCount;
//    @Embedded
//    private ProductDetails productDetails;
//    @Builder.Default
//    private boolean status = true;
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Brand brand;


//    public void addComment(String comment) {
//        this.comment.add(comment);
//    }

//    public void setStar(byte star) {
//        if (star > 5) {
//            this.star = (byte) ((byte) (this.star + 5) / 2);
//        } else {
//            this.star = (byte) ((byte) (this.star + star) / 2);
//        }
//    }

//    @Override
//    public String toString() {
//        return "Product{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
////                ", amount=" + amount +
////                ", comment=" + comment +
//                ", like=" + like +
////                ", star=" + star +
//                ", remainCount=" + remainCount +
////                ", productDetails=" + productDetails +
////                ", status=" + status +
//                '}';
//    }
}
