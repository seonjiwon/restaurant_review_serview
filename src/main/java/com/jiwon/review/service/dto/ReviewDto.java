package com.jiwon.review.service.dto;

import com.jiwon.review.model.ReviewEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ReviewDto {

  private Double avgScore;
  private List<ReviewEntity> reviews;
  private ReviewDtoPage page;


  @Getter
  @AllArgsConstructor
  @Builder
  public static class ReviewDtoPage{

    private Integer offset;
    private Integer limit;
  }
}
