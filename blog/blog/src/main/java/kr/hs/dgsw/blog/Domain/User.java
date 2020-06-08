package kr.hs.dgsw.blog.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;



import lombok.Data;
import lombok.NoArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.math.BigInteger;
import java.security.MessageDigest;
import javax.persistence.Id;
import java.security.NoSuchAlgorithmException;

@Entity
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(nullable = false, unique = true, length = 20)
  private String account;
  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public void setPaaword(String password) {
      try {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(password.getBytes(), 0, password.getBytes().length);
        this.password = new BigInteger(1, md.digest()).toString(16);
      } catch (NoSuchAlgorithmException e) {
        Logger logger = LoggerFactory.getLogger(User.class);
        logger.warn(e.getMessage());
      }
    }
    
    @Column(nullable = false)
    private String name;  
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String profilePath;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime modified;
  
    public User(String account, String password, String name, String email, String phone, String profilePath) {
      this.account = account;
      setPassword(password);
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.profilePath = profilePath;
    }
}