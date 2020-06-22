package dgsw.hs.kr.webshopping.Domain;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Review {
  private Long id;
  private Long productId;
  private String userName;
  private String content;
  private LocalDateTime created;
  private LocalDateTime modified;
  
}