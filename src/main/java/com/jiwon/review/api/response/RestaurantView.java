package com.jiwon.review.api.response;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantView {

  private Long id;
  private final String name;
  private final String address;
  private final ZonedDateTime createdAt;
  private final ZonedDateTime updatedAt;
}
