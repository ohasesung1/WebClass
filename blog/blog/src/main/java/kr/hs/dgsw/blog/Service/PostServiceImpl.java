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

@Service
public class PostServiceImpl implements PostService{
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private UserRepository userRepository;

  @PostConstruct
  private void init() {
    User user = userRepository.save(new User("imrimee01", "1234", "오해성11", "tset@dgsw.hs.kr",
    "010-1234-1234", "https://image"));
    postRepository.save(new Post(user.getId(), "안녕하세요.", "첫 번째 게시물 입니다."));
  }

  @Override
  public Post create(Post post) {
    return postRepository.save(post);
  }

  @Override
  public Post read(Long id) {
    return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
  }

  public Post readByUserId(Long userId) {
    return postRepository
          .findTopByUserIdOrderByIdDesc(userId)
          .orElse(null);
  }

  @Override
  public Post update(Long id, Post post) {
    return postRepository.findById(id)
          .map(found -> {
            found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
            found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
            found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
            return postRepository.save(found);
          })
          .orElse(null);
  } 

  @Override
  public boolean delete(Long id) {
    try {
      postRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public List<Post> readAll() {
    return postRepository.findAll();
  }


}