package com.jiwon.review.api;

import com.jiwon.review.api.request.CreateAndEditRestaurantRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantApi {

  @GetMapping("/restaurants")
  public String getRestaurants() {
    return "This is getRestaurants";
  }


  @GetMapping("/restaurant/{restaurantId}")
  public String getRestaurant(
      @PathVariable Long restaurantId
  ) {
    return "This is getRestaurant";
  }

  @PostMapping("/restaurant")
  public String createRestaurant(
      @RequestBody CreateAndEditRestaurantRequest request
  ) {
    return "This is getRestaurants, name = " + request.getName() + ", address= "
        + request.getAddress()
        + ", menu[0].name" + request.getMenus().get(0).getName() + ", menu[0].price = "
        + request.getMenus().get(0).getPrice();
  }

  @PutMapping("/restaurant/{restaurantId}")
  public String editRestaurant(
      @PathVariable Long restaurantId,
      @RequestBody CreateAndEditRestaurantRequest request
  ) {
    return "This is editRestaurant, " + restaurantId + "name = " + request.getName() + ", address= " + request.getAddress();
  }

  @DeleteMapping("/restaurant/{restaurantId}")
  public String deleteRestaurant(
      @PathVariable Long restaurantId
  ) {
    return "This is deleteRestaurant, " + restaurantId;
  }
}
