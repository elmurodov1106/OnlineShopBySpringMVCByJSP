package uz.g22.entity.order;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import uz.g22.entity.BaseEntity;
import uz.g22.entity.product.Product;
import uz.g22.entity.user.User;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderEntity extends BaseEntity {
    @Column(name = "amount")
    private int amount;

    private double price;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private User user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
