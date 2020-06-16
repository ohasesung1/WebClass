package dgsw.hs.kr.webshopping.Domain;

import java.util.List;

public interface SubMenuMapper {
  List<SubMenu> findByMenuId(Long menuId);
  SubMenu findById(Long id);
}