package hs.kr.dgsw.webclass02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hs.kr.dgsw.webclass02.Domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
  
}