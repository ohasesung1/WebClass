package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgsw.hs.kr.webshopping.Domain.Menu;
import dgsw.hs.kr.webshopping.Domain.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService{ 
  @Autowired
  MenuMapper menuMapper;

  @Override
  public List<Menu> findAll() {
    return menuMapper.findAll();
  }

  @Override
  public Menu findById(Long id) {
    return menuMapper.findById(id);
  }


}