package kr.hs.dgsw.blog.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.blog.Domain.User;
import kr.hs.dgsw.blog.Protocol.ResponseFormat;
import kr.hs.dgsw.blog.Protocol.ResponseType;
import kr.hs.dgsw.blog.Service.UserService;

@RestController //@RestController 는 @Controller 어노테이션과 @ResponseBody 어노테이션을 합쳐놓은 어노테이션이다.
public class UserContoller {
  @Autowired //@Autowired란 생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, 해당 빈을 찾아서 주입해주는 annotation이다
  private UserService userService;

  @PostMapping("/user/create")
  public ResponseFormat create(@RequestBody User user) {
    User newUser = userService.create(user);
    if (newUser != null) {
      return new ResponseFormat(
        ResponseType.USER_ADD, 
        newUser,
        newUser.getId()
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @PutMapping("/user/update/{id}")
  public ResponseFormat update(@PathVariable Long id, @RequestBody User user) {
    if (userService.update(id, user) != null) {
      return new ResponseFormat(
        ResponseType.USER_UPDATE,
        userService.update(id, user),
        user.getId()
      );
    } else {
      return new ResponseFormat(
        ResponseType.FAIL,
        null
      );
    }
  }

  @DeleteMapping("/user/delete/{id}")
  public ResponseFormat delete(@PathVariable Long id) {
    if (userService.delete(id)) {
      return new ResponseFormat(ResponseType.USER_DELETE,
          userService.delete(id),
          id
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

  @GetMapping("/user/read/{id}")
  public ResponseFormat read(@PathVariable Long id) {
    if (userService.read(id) != null) {
      return new ResponseFormat(
        ResponseType.USER_GET,
        userService.read(id),
        id
      );
    } else {
      return new ResponseFormat(
        ResponseType.FAIL, null
        );
    }
  }

  @GetMapping("/user/read")
  public ResponseFormat readAll() {
    if (userService.readAll() != null) {
      return new ResponseFormat(
        ResponseType.USER_GET_ALL,
        userService.readAll()
      );
    } else {
      return new ResponseFormat(ResponseType.FAIL, null);
    }
  }

}