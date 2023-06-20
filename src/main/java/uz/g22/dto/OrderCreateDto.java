package uz.g22.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.g22.entity.card.CardEntity;
import uz.g22.entity.order.OrderStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreateDto {
    private Integer amount;
    private OrderStatus status;
//    private CardEntity card;
}
