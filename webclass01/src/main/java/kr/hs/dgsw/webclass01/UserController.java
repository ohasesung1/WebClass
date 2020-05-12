package kr.hs.dgsw.webclass01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    // 모든 리스트 조회
    @GetMapping("/user")
    @ResponseBody
    public List<User> list() {
      return userService.list();
    }

    // id값에 해당되는 리스트 조회
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) {
      return userService.view(id);
    }

    // 유저를 추가 시키는 함수
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) {
      return userService.add(user);
    }

    // 해당 유저를 업데이트 시키는 함수
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) {
      return userService.update(user);
    }

    // 해당 유저 id값을 삭제 시키는 함수
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) {
      return userService.delete(id);
    }
}