package com.jiwon.review.api.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CreateAndEditRestaurantRequestMenu {

  private final String name;
  private final Integer price;

}
