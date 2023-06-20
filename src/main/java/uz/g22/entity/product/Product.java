package uz.g22.entity.product;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import uz.g22.entity.BaseEntity;
import uz.g22.entity.user.User;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
@Builder
public class Product extends BaseEntity {

    private String name;

    private String description;

    private Double price;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User user;
}
