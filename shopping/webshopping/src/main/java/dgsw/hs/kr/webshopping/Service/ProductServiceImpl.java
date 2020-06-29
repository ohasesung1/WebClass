package dgsw.hs.kr.webshopping.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgsw.hs.kr.webshopping.Domain.Product;
import dgsw.hs.kr.webshopping.Domain.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService{
  @Autowired
  ProductMapper productMapper;

  @Override
  public Long add(Product product) {
    return productMapper.add(product);
  }

  @Override
  public int modify(Product product) {
    return productMapper.modify(product);
  }

  @Override
  public int deleteById(Long id) {
    return productMapper.deleteById(id);
  }

  @Override
  public Product findById() {
    
  }
}