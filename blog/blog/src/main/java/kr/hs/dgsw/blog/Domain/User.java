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

@Entity  // JPA에서 엔티티는 테이블에 대응하는 하나의 클래스 이다
@Data // 람북 getter, setter 설정
@NoArgsConstructor //모든 필드 값을 파라미터로 받는 생성자를 만들어 줌
public class User {
  @Id// primary key 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값 자동 증가
  private long id;
  @Column(nullable = false, unique = true, length = 20) // 길이, 고유 값 설정
  private String account;
  @Column(nullable = false)
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;

  public void setPaaword(String password) { // 비밀번호 데이터 설정
      try {
        MessageDigest md = MessageDigest.getInstance("SHA-512"); // 비밀번호 암호화
        md.update(password.getBytes(), 0, password.getBytes().length); // 암호화
        this.password = new BigInteger(1, md.digest()).toString(16); // 암호화
      } catch (NoSuchAlgorithmException e) {
        Logger logger = LoggerFactory.getLogger(User.class);
        logger.warn(e.getMessage());
      }
    }
    
    @Column(nullable = false) // not null
    private String name;  
    @Column(unique = true) // 고유 값 설정
    private String email;
    @Column(unique = true) // 고유 값 설정
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String profilePath;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 데이트 정보 조회
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 데이트 정보 조회
    private LocalDateTime modified;
  
    public User(String account, String password, String name, String email, String phone, String profilePath) { // 유저 정보 추가
      this.account = account;
      setPassword(password);
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.profilePath = profilePath;
    }
}