package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "brands")
@NamedQueries({
        @NamedQuery(name = "findAll",query = "select b from Brand b"),
        @NamedQuery(name = "findByName",query = "select b from Brand b where b.name  like :name or b.description like :description")

})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
//    @OneToMany(mappedBy = "brand",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private Set<Product> products;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
//                ", products='" + products + '\'' +
                '}';
    }
}
