package kr.hs.dgsw.blog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.blog.Domain.User;

@Repository // 어떤 클래스가 그 역할을 충족시켰거나 레파지토리의 stereotype 이라는 표시
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByAccount(String account);
}

