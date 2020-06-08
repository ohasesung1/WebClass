package kr.hs.dgsw.blog.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // JPA에서 엔티티는 테이블에 대응하는 하나의 클래스 이다
@Data // 람북 getter, setter 설정
public class Attachment {
  @Id // 고유 id 설정 primary key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // id 자동 증가
  private Long id;
  private String storedPath;
  private Long postId;
}