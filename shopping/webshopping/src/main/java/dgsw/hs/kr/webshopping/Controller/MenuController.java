package dgsw.hs.kr.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dgsw.hs.kr.webshopping.Domain.Menu;
import dgsw.hs.kr.webshopping.Service.MenuService;

@RestController
public class MenuController {
  @Autowired
  MenuService menuService;

  @GetMapping(value="/api/menu")
  public List<Menu> findAll() {
    return menuService.findAll();
  }

  @GetMapping(value="/api/menu/id")
  public Menu findById(@Param("id") Long id) {
    return menuService.findById(id);
  }
}