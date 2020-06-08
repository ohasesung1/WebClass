package kr.hs.dgsw.blog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  // JPA에서 엔티티는 테이블에 대응하는 하나의 클래스 이다
@Data // 람북 getter, setter 설정
@NoArgsConstructor  //모든 필드 값을 파라미터로 받는 생성자를 만들어 줌
public class Post {
  @Id // 고유 id 설정  primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY)// id 자동 증가
  private Long id;
  @Column(nullable = false) // not null
  private Long userId;
  @Column(nullable = false) // not null
  private String title;

  @Column(nullable = false, columnDefinition = "TEXT") // not null type : text
  private String content;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
  private List<Attachment> pictures;
  @CreationTimestamp // 데이트 설정
  @Column(updatable = false, nullable = false)
  @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 시간 데이터 조회
  private LocalDateTime created;
  @UpdateTimestamp 
  @Column(nullable = false) // not null
  @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 시간 데이터 조회
  private LocalDateTime morified;

  public Post(Long userId, String title, String content) { // 데이터 저장
    this.userId = userId;
    this.title = title;
    this.content = content;
  }
}