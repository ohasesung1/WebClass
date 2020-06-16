package dgsw.hs.kr.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
  List<User> findAll();
  int deleteById(@Param("id") Long id);
  Long add(User user);
  int modity(User user);
  User findById(@Param("id") Long id);
  Long login(User user);
}