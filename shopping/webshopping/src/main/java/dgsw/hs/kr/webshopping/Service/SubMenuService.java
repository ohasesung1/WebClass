package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import dgsw.hs.kr.webshopping.Domain.SubMenu;

public interface SubMenuService {
  List<SubMenu> findByMenuId(Long menuId);
  SubMenu findById(Long id);
}