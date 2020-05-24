package hs.kr.dgsw.webclass02.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hs.kr.dgsw.webclass02.Domain.Comment;
import hs.kr.dgsw.webclass02.Domain.User;
import hs.kr.dgsw.webclass02.Protocol.CommentUsernameProtocol;
import hs.kr.dgsw.webclass02.Repository.CommentRepository;
import hs.kr.dgsw.webclass02.Repository.UserRepository;

@Service
public class CommentServiceImpl implements CommentService{
  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  private UserRepository userRepository;

  @PostConstruct
  private void init() {
      User user = userRepository.save(new User("aaa", "aaa@dgsw", "1234", null, null));
      commentRepository.save(new Comment(user.getId(), "hi there1", null, null));
  }


  @Override
  public CommentUsernameProtocol add(Comment comment) {
    return new CommentUsernameProtocol(
        commentRepository.save(comment),
        userRepository.findById(comment.getUserId())
        .map(found -> found.getUsername())
        .orElse(null));
  }

  @Override
  public boolean remove(Long id) {
    try {
      commentRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

@Override
  public CommentUsernameProtocol update(Long id, Comment comment) {
    Optional<User> user = userRepository.findById(comment.getUserId());
    if (user.isPresent()) {
      return commentRepository.findById(id)
              .map(found -> {
                found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
                found.setStoredPath(Optional.ofNullable(comment.getStoredPath()).orElse(found.getStoredPath()));
                found.setOriginalName(Optional.ofNullable(comment.getOriginalName()).orElse(found.getOriginalName()));
                commentRepository.save(found);
                return new CommentUsernameProtocol(found, user.get().getUsername());
              })
              .orElse(null);
    }

    return null;
  }

@Override
public CommentUsernameProtocol view(Long id) {
  return commentRepository.findById(id)
          .map(found -> {
            Optional<User> user = userRepository.findById(found.getUserId());
            String username = user.isPresent() ? user.get().getUsername() : null;
            return new CommentUsernameProtocol(found, username);
          })
          .orElse(null);
}


@Override
public List<CommentUsernameProtocol> listAllComments() {
  List<Comment> commentList = commentRepository.findAll();
  List<CommentUsernameProtocol> cupList = new ArrayList<>();
  commentList.forEach(comment -> {
    Optional<User> found = userRepository.findById(comment.getUserId());
    String username = found.isPresent() ? found.get().getUsername() : null;
    cupList.add(new CommentUsernameProtocol(comment, username));
  });
	return null;
}
}