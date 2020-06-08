package kr.hs.dgsw.blog.Service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.blog.Domain.Post;
import kr.hs.dgsw.blog.Domain.User;
import kr.hs.dgsw.blog.Repository.PostRepository;
import kr.hs.dgsw.blog.Repository.UserRepository;

@Service // Service의 역할은 Dao가 DB에서 받아온 데이터를 전달받아 가공하는 것
public class PostServiceImpl implements PostService{ // 인터페이스 참조
  @Autowired //의존하고 있는 Bean을 자동으로 주입해 주는 것
  private PostRepository postRepository; // Repository 가져오기
  @Autowired //의존하고 있는 Bean을 자동으로 주입해 주는 것
  private UserRepository userRepository; // Repository 가져오기

  @PostConstruct
  private void init() { // 첫 게시글 작성 함수
    User user = userRepository.save(new User("imrimee01", "1234", "오해성11", "tset@dgsw.hs.kr",
    "010-1234-1234", "https://image")); // 유저 정보 저장
    postRepository.save(new Post(user.getId(), "안녕하세요.", "첫 번째 게시물 입니다.")); // 게시글 정보 저장
  }

  @Override
  public Post create(Post post) { // 게시글 작성
    return postRepository.save(post); // 게시글 저장 
  }

  @Override
  public Post read(Long id) { // 게시글 하나 가져오기
    return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null; // 게시글이 있을 경우 해당 데이터 return 없다면 null return
  }

  public Post readByUserId(Long userId) { // 사용자 id에 따라 가져오기
    return postRepository
          .findTopByUserIdOrderByIdDesc(userId) // 사용자 id에 따라 게시글 정렬 조회
          .orElse(null); // 없다면 null return
  }

  @Override
  public Post update(Long id, Post post) { // 게시글 수정
    return postRepository.findById(id) // 게시글 찾기
          .map(found -> { // 데이터 새롭게 설정
            found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
            found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
            found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
            return postRepository.save(found); // 데이터 저장
          })
          .orElse(null); // 없다면 null return
  } 

  @Override
  public boolean delete(Long id) { // 게시글 삭제
    try {
      postRepository.deleteById(id); // 식제
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public List<Post> readAll() {
    return postRepository.findAll(); // 전체 조회
  }


}