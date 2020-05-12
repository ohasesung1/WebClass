package kr.hs.dgsw.webclass01;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private @NonNull String id;
  private @NonNull String name;
  private @NonNull String email;

  // @Override
  // public String toString() {
  //   return id + "/" + name + "/" + email;
  // }

  // public User() {}

  // public User(String id, String name, String email) {
  //   this.id = id;
  //   this.name = name;
  //   this.email = email;
  // }

  // public String getId() {
  //   return id;
  // }

  // public void setId(String id) {
  //   this.id = id;
  // }

  // public String getName() {
  //   return name;
  // }

  // public void setName(String name) {
  //   this.name = name;
  // }

  // public String getEmail() {
  //   return email;
  // }

  // public void setEmail(String email) {
  //   this.email = email;
  // }
}