package com.jiwon.review.service;

import com.jiwon.review.api.response.RestaurantDetailView;
import com.jiwon.review.api.response.RestaurantView;
import com.jiwon.review.model.MenuEntity;
import com.jiwon.review.repository.MenuRepository;
import com.jiwon.review.repository.RestaurantRepository;
import com.jiwon.review.api.request.CreateAndEditRestaurantRequest;
import com.jiwon.review.model.RestaurantEntity;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

  private final RestaurantRepository restaurantRepository;
  private final MenuRepository menuRepository;


  @Transactional
  public RestaurantEntity createRestaurant(
      CreateAndEditRestaurantRequest request
  ) {
    RestaurantEntity restaurant = RestaurantEntity.builder()
                                                  .name(request.getName())
                                                  .address(request.getAddress())
                                                  .createAt(ZonedDateTime.now())
                                                  .updateAt(ZonedDateTime.now())
                                                  .build();
    restaurantRepository.save(restaurant);

    request.getMenus().forEach((menu) -> {
      MenuEntity menuEntity = MenuEntity.builder()
                                        .restaurantId(restaurant.getId())
                                        .name(menu.getName())
                                        .price(menu.getPrice())
                                        .createdAt(ZonedDateTime.now())
                                        .updatedAt(ZonedDateTime.now())
                                        .build();

      menuRepository.save(menuEntity);
    });

    return restaurant;
  }

  @Transactional
  public void editRestaurant(
      Long restaurantId,
      CreateAndEditRestaurantRequest request
  ) {
    RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
        () -> new RuntimeException("없는 레스토랑 입니다."));
    restaurant.changeNameAndAddress(request.getName(), request.getAddress());
    restaurantRepository.save(restaurant);

    List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
    menuRepository.deleteAll(menus);

    request.getMenus().forEach((menu) -> {
      MenuEntity menuEntity = MenuEntity.builder()
                                        .restaurantId(restaurantId)
                                        .name(menu.getName())
                                        .price(menu.getPrice())
                                        .createdAt(ZonedDateTime.now())
                                        .updatedAt(ZonedDateTime.now())
                                        .build();
      menuRepository.save(menuEntity);
    });
  }

  @Transactional
  public void deleteRestaurant(Long restaurantId) {
    RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
    restaurantRepository.delete(restaurant);

    List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);
    menuRepository.deleteAll(menus);
  }

  @Transactional(readOnly = true)
  public List<RestaurantView> getAllRestaurant() {
    List<RestaurantEntity> restaurants = restaurantRepository.findAll();

    return restaurants.stream().map((restaurant) -> RestaurantView.builder()
                                                                  .id(restaurant.getId())
                                                                  .name(restaurant.getName())
                                                                  .address(restaurant.getAddress())
                                                                  .createdAt(
                                                                      restaurant.getCreateAt())
                                                                  .updatedAt(
                                                                      restaurant.getUpdateAt())
                                                                  .build())
                                                                  .toList();
  }

  @Transactional(readOnly = true)
  public RestaurantDetailView getRestaurantDetail(Long restaurantId) {
    RestaurantEntity restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
    List<MenuEntity> menus = menuRepository.findAllByRestaurantId(restaurantId);

    return RestaurantDetailView.builder()
                               .id(restaurant.getId())
                               .name(restaurant.getName())
                               .address(restaurant.getAddress())
                               .createdAt(restaurant.getCreateAt())
                               .updatedAt(restaurant.getUpdateAt())
                               .menus(
                                   menus.stream().map((menu) -> RestaurantDetailView.Menu.builder()
                                                                                         .id(menu.getId())
                                                                                         .name(
                                                                                             menu.getName())
                                                                                         .price(
                                                                                             menu.getPrice())
                                                                                         .createdAt(
                                                                                             menu.getCreatedAt())
                                                                                         .updatedAt(
                                                                                             menu.getUpdatedAt())
                                                                                         .build()
                                   ).toList()
                               ).build();

  }
}
