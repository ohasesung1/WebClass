package dgsw.hs.kr.webshopping.Service;

import java.util.List;

import dgsw.hs.kr.webshopping.Domain.Cart;

public interface CartService {
  Long add(Cart cart);
  int deleteById(Long id);
  int deleteByUserId(Long userId);
  Cart findById(Long id);
  List<Cart> findUserId(Long userId);
}