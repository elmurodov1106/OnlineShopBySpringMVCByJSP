package uz.g22.entity.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;
import uz.g22.entity.BaseEntity;
import uz.g22.entity.history.History;
import uz.g22.entity.product.Product;

import java.util.List;

@Entity(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Builder
public class User extends BaseEntity {

    private String name;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "email cannot be empty or null")

    @Email(message = "enter valid email address")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "password cannot be empty or null")

    private String password;

    private double balance;

    @Enumerated(EnumType.STRING)
    private UserRole role ;

//    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Product> productEntities;
//
//    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<History> historyEntities;


}
