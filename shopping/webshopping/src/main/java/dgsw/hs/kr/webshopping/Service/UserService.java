package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import dgsw.hs.kr.webshopping.Domain.User;

public interface UserService {
  List<User> findAll();
  User findById(Long id);
  User findByAccount(String account);
  int deleteById(Long id);
  Long add(User user);
  int modify(User user);
  int login(User user);
}