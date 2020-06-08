package kr.hs.dgsw.blog.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.hs.dgsw.blog.Domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
  Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);
}