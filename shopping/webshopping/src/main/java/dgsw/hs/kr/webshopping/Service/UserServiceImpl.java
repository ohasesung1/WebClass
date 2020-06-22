package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgsw.hs.kr.webshopping.Domain.User;
import dgsw.hs.kr.webshopping.Domain.UserMapper;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  UserMapper userMapper;

  @Override
  public List<User> findAll() {
    return userMapper.findAll();
  }

  @Override
  public int deleteById(Long id) {
    return userMapper.deleteById(id);
  }

  @Override
  public Long add(User user) {
    return userMapper.add(user);
  }

  @Override
  public int modify(User user) {
      return userMapper.modity(user);
  }

  @Override
  public User findById(Long id) {
    return userMapper.findById(id);
  }

  @Override
  public User findByAccount(String account) {
    return userMapper.findByAccount(account);
  }
}