package com.jiwon.review.repository;

import com.jiwon.review.model.MenuEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

  public List<MenuEntity> findAllByRestaurantId(Long restaurantId);

}
