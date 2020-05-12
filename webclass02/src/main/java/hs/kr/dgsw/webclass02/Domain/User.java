package hs.kr.dgsw.webclass02.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
  @Id
  private Integer id;
  private String name;
  private String email;
  private String password;
    
}