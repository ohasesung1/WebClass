package dgsw.hs.kr.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper {
  List<Menu> findAll();
  Menu findById(Long id);
}