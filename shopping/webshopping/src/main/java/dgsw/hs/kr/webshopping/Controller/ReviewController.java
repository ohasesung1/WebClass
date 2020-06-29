package dgsw.hs.kr.webshopping.Controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import dgsw.hs.kr.webshopping.Domain.Review;
import dgsw.hs.kr.webshopping.Service.ReviewService;

public class ReviewController {
  @Autowired
  ReviewService reviewService;

  @PostMapping(value="/api/review")
  public Long add(@RequestBody Review review){
    return reviewService.add(review);
  }

  @DeleteMapping(value="/api/review")
  public int deleteById(@Param("id") Long id) {
    return reviewService.deleteById(id);
  }

  @GetMapping(value="/api/review/productid")
  public List<Review> findByProductId(@Param("productId") Long productId) {
    return reviewService.findByProductId(productId);
  }

  @PutMapping(value="/api/review")
  public int modify(@RequestBody Review review) {
    return reviewService.modify(review);
  }

  
}