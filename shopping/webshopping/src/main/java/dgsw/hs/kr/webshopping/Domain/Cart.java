package dgsw.hs.kr.webshopping.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cart {
  private Long id;
  private String userId;
  private Long productId;
  private int price;
  private int amount;
  private int total;
}