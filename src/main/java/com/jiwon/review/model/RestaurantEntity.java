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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restaurant")
public class RestaurantEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String address;
  private ZonedDateTime createAt;
  private ZonedDateTime updateAt;

  public void changeNameAndAddress(String name, String address) {
    this.name = name;
    this.address = address;
    this.updateAt = ZonedDateTime.now();
  }
}
