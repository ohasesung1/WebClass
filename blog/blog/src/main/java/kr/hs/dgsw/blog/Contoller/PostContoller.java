package kr.hs.dgsw.blog.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.blog.Domain.Post;
import kr.hs.dgsw.blog.Protocol.ResponseFormat;
import kr.hs.dgsw.blog.Protocol.ResponseType;
import kr.hs.dgsw.blog.Service.PostService;

@RestController //@RestController 는 @Controller 어노테이션과 @ResponseBody 어노테이션을 합쳐놓은 어노테이션이다.
public class PostContoller {
  @Autowired //@Autowired란 생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, 해당 빈을 찾아서 주입해주는 annotation이다
  private PostService postService;

  @PostMapping("/post/create") // rest api Post
  public ResponseFormat create(@RequestBody Post post) {
    Post newPost = postService.create(post);
    if (newPost != null) {
      return new ResponseFormat(
        ResponseType.POST_ADD,
        newPost,
        newPost.getId()
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @PutMapping("/post/update/{id}") // rest api put
  public ResponseFormat update(@PathVariable Long id, @RequestBody Post post) {
    if (postService.update(id, post) != null) {
      return new ResponseFormat(
        ResponseType.POST_UPDATE,
        postService.update(id, post),
        post.getId()
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }


  @DeleteMapping("/post/delete/{id}") // rest api delete
  public ResponseFormat delete(@PathVariable Long id) {
    if (postService.delete(id)) {
      return new ResponseFormat(
        ResponseType.USER_DELETE,
        postService.delete(id),
        id
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read/{id}") // rest api get
  public ResponseFormat read(@PathVariable Long id) {
    if (postService.read(id) != null) {
      return new ResponseFormat(
        ResponseType.POST_GET,
        postService.read(id),
        id
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read/user/{userId}")// rest api get
  public ResponseFormat readByUserId(@PathVariable Long userId) {
    if (postService.readByUserId(userId) != null) {
      return new ResponseFormat(
        ResponseType.POST_GET_BY_USER,
        postService.readByUserId(userId),
        userId
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/post/read") // rest api get
  public ResponseFormat readAll() {
    if (postService.readAll() != null) {
      return new ResponseFormat(
        ResponseType.POST_GET_ALL,
        postService.readAll()
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }
}