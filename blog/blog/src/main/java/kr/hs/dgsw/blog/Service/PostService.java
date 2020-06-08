package kr.hs.dgsw.blog.Service;

import java.util.List;

import kr.hs.dgsw.blog.Domain.Post;

public interface PostService { // POST 서비스 인터페이스
  Post create(Post post); // 게시글 작성
  Post read(Long id); // 게시글 하나만 가져오기
  Post readByUserId(Long userId); // 사용자 ID에 따라 게시글 가져오기
  Post update(Long id, Post post); // 게시글 수정
  boolean delete(Long id); // 게시글 삭제
  List<Post> readAll(); // 게시글 전체 가져오기
}