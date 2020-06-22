package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import dgsw.hs.kr.webshopping.Domain.Menu;

public interface MenuService {
  List<Menu> findAll();
  Menu findById(Long id);
}