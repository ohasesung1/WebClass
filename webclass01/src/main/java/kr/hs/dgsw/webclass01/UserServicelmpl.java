package kr.hs.dgsw.webclass01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl implements UserService {
  List<User> userList; // userList 변수 선언

  // add 함수 기능 구현
  public UserServicelmpl() {
    userList = new ArrayList<>(); // arrayList를 사용하기위한 변수 선언
    userList.add(new User("user1", "오해성", "test1@dgsw")); // userList 초기 데이터 설정
    userList.add(new User("user2", "오해", "test2@dgsw")); // userList 초기 데이터 설정
    userList.add(new User("user3", "오", "test3@dgsw")); // userList 초기 데이터 설정
  }

  // 전체 리스트 조회 함수 기능 구현
  @Override // 전에 구현된 상속 받은 부모 클래스의 메서드를 새로 쓰고 싶은 경우 override해준다
  public List<User> list() { // List 타입의 전체 리스트 조회 함수
    return userList; // userList 리턴
  }

  // 특정 id 값의 데이터 조회 기능 구현
  @Override // 전에 구현된 상속 받은 부모 클래스의 메서드를 새로 쓰고 싶은 경우 override해준다
  public User view(String id) {
    User user = userList.stream()
                .filter(found -> found.getId().equals(id))
                .findAny()
                .orElse(null);
    return user; // user 리턴
  }

  // 유저를 추가하는 함수
  @Override // 전에 구현된 상속 받은 부모 클래스의 메서드를 새로 쓰고 싶은 경우 override해준다
  public boolean add(User user) {  // 리스트에 추가하는 함수
    User found = view(user.getId());
    if (found == null) 
        return userList.add(user);
    return false; // 조건이 맞지 않을 경우 false리턴
  }

  // 특정 id의 데이터를 수정하는 함수
  @Override // 전에 구현된 상속 받은 부모 클래스의 메서드를 새로 쓰고 싶은 경우 override해준다
  public User update(User user) { // 이름과 이메일만 변경하게 하는 함수
    User found = view(user.getId()); // view 에 userid 가져오기
    if (found != null) 
        found.setName(user.getName());
        found.setEmail(user.getEmail());
    return found; // found 리턴
  }

  // 특정 id의 값을 삭제하는 함수
  @Override // 전에 구현된 상속 받은 부모 클래스의 메서드를 새로 쓰고 싶은 경우 override해준다
  public boolean delete(String id) { // 특정 id의 값의 행을 삭제하는 함수
    User found = view(id);// view 에 userid 가져오기
    return userList.remove(found); // array의 remove 함수 호출 후 리턴
  }

  public User find1(String name) { 
    for(int i = 0; i < userList.size(); i++) { // userList의 길이 만큼 for문 작동
      User user = userList.get(i);// view 에 userid 가져오기
      if (user.getName().equals(name)) return user;
    }

    return null;
  }

  public User find2(String name) { 
   Iterator<User> iterator = userList.iterator();
   while(iterator.hasNext()) {
     User user = iterator.next();
     if(user.getName().equals(name)) return user;
   }

   return null;
  }

  public User find3(String name) { 
   for (User user : userList) { 
     if (user.getName().equals(name)) return user;
   }

   return null;
  }
}