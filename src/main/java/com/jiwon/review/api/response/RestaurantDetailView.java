package com.jiwon.review.api.response;

import java.time.ZonedDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RestaurantDetailView {

  private final Long id;
  private final String name;
  private final String address;
  private final ZonedDateTime createdAt;
  private final ZonedDateTime updatedAt;
  private final List<Menu> menus;

  @Builder
  @AllArgsConstructor
  @Getter
  public static class Menu {

    private final Long id;
    private final String name;
    private final Integer price;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;

  }
}
