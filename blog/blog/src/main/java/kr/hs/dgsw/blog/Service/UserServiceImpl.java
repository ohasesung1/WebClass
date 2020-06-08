package kr.hs.dgsw.blog.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.hs.dgsw.blog.Domain.User;
import kr.hs.dgsw.blog.Repository.UserRepository;

@Service // Service의 역할은 Dao가 DB에서 받아온 데이터를 전달받아 가공하는 것
public class UserServiceImpl implements UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public User create(User user) { // 유저 정보 저장
    Optional<User> found = userRepository.findByAccount(user.getAccount()); // 저장시 기존 유저가 있는지 확인
    if (found.isPresent()) return null; // 있다면 null return
    return userRepository.save(user); // 없다면 저장된 유저 return
  }

  @Override
  public User update(Long id, User user) { // 유저 정보 수정
    return userRepository.findById(id) // 유저 찾기
            .map(found -> { // 유저 정보 수정
              found.setPaaword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
              found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
              found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
              found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
              found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
              return userRepository.save(found); // 성공시 수정된 유저 return
            })
            .orElse(null); // 없다면 null return
  }

  @Override
  public boolean delete(Long id) { // 유저 삭제
    try {
      userRepository.deleteById(id); // 삭제
      return true;
    } catch (Exception e) {
      return false;
    }
  }


  @Override
  public User read(Long id) { // 유저 조회
    Optional<User> user = userRepository.findById(id); // 유저 찾기
    return user.isPresent() ? user.get() : null; // 있다면 해당 정보 return 없다면 null return
  }

  @Override
  public List<User> readAll() { // 유저 전체 정보 조회
    return userRepository.findAll(); // 조회
  }
}