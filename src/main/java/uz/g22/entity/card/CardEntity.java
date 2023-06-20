package uz.g22.entity.card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import uz.g22.entity.BaseEntity;
import uz.g22.entity.user.User;

@Entity(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class CardEntity extends BaseEntity{

    private String number;

    private String expire_date;

    private Double balance;
    private String  password;

    @ManyToOne
    @JoinColumn(name = "owner_id",referencedColumnName = "id")
    private User user;

    @Column(name = "card_type")
    @Enumerated(EnumType.STRING)
    private CardType card_type;



}
