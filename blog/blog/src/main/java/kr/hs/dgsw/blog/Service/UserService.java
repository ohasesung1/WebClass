package kr.hs.dgsw.blog.Service;

import java.util.List;

import kr.hs.dgsw.blog.Domain.User;

public interface UserService { // 사용자 service 인터 페이스
  User create(User user); // 유저 추가
  User read(Long id); // 유저 한명 조회
  User update(Long id, User user); // 유저 정보 수정
  boolean delete(Long id); // 유저 삭제
  List<User> readAll(); // 전체 유저 조회
}