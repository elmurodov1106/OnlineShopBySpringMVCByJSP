package uz.g22.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.g22.entity.product.ProductCategory;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoryCreateDto {

    private ProductCategory category;

    private String description;

    private String name;

    private Double price;

//    private String seller_name;

    private Integer amount;


}
