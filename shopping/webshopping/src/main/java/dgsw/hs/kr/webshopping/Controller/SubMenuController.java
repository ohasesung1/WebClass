package dgsw.hs.kr.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import dgsw.hs.kr.webshopping.Domain.SubMenu;
import dgsw.hs.kr.webshopping.Service.SubMenuService;

public class SubMenuController {
  @Autowired
  SubMenuService subMenuService;

  @GetMapping(value="/api/subMenu/menuId")
  public List<SubMenu> findByMenuId(@Param("menuId") Long menuId) {
    return subMenuService.findByMenuId(menuId);
  }

  @GetMapping(value="/api/subMenu/id")
  public SubMenu findById(@Param("id") Long id) {
    return subMenuService.findById(id);
  }

  
}