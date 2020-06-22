package dgsw.hs.kr.webshopping.Domain;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
  Long add(Product product);
  int modify(Product product);
  int deleteById(@Param("id") Long id);
  Product findById(@Param("id") Long id);
  List<Product> findByMenuId(@Param("menuId") Long menuId);
  List<Product> findBySubMenuId(@Param("subMenuId") Long subMenuId);
  List<Product> findAll();
}