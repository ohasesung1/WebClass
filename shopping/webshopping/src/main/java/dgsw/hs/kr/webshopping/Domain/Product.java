package dgsw.hs.kr.webshopping.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
  private Long id;
  private String name;
  private int price;
  private Long menuId;
  private String defails;
  private String factory;
  
}