package uz.g22.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FillBalanceDto {
//    private String  sender_number;
  private String receiver_number;
 private Double amount;
}
