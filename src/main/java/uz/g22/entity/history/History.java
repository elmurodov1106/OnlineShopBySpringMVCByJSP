package uz.g22.entity.history;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import uz.g22.entity.BaseEntity;
import uz.g22.entity.product.ProductCategory;
import uz.g22.entity.user.User;

@Entity(name = "histories")
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class History extends BaseEntity {

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_description")
    private String product_description;

    @Column(name = "product_price")
    private Double product_price;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_category")
    private ProductCategory product_category;

    @Column(name = "product_amount")
    private Integer product_amount;

//    @Column(name = "seller_name")
//    private String seller_name;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User users;

}
