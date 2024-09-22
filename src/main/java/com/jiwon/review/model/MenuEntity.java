package com.jiwon.review.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class MenuEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Long restaurantId;
  private String name;
  private Integer price;
  private ZonedDateTime createdAt;
  private ZonedDateTime updatedAt;
}
