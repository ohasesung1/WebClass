package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import dgsw.hs.kr.webshopping.Domain.Product;

public interface ProductService {
  List<Product> findAll();
  int deleteById(@Param("id") Long id);
  Long add(Product product);
  int modify(Product product);
  Product findById(@Param("id") Long id);
  List<Product> findByMenuId(@Param("menuId") Long menuId);
  List<Product> findBySubMenuId(@Param("subMenuId") Long subMenuId);
}