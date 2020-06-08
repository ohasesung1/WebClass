package kr.hs.dgsw.blog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.hs.dgsw.blog.Domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByAccount(String account);
}

