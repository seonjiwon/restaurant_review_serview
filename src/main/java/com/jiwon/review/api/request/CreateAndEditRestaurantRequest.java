package com.jiwon.review.api.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateAndEditRestaurantRequest {

  private final String name;
  private final String address;
  private final List<CreateAndEditRestaurantRequestMenu> menus;
}
