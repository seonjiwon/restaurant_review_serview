package com.jiwon.review.service;

import com.jiwon.review.model.ReviewEntity;
import com.jiwon.review.repository.RestaurantRepository;
import com.jiwon.review.repository.ReviewRepository;
import java.time.ZonedDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {

  private final RestaurantRepository restaurantRepository;
  private final ReviewRepository reviewRepository;

  @Transactional
  public void createReview(Long restaurantId, String content, Double score) {
    restaurantRepository.findById(restaurantId).orElseThrow();

    ReviewEntity review = ReviewEntity.builder()
                                      .restaurantId(restaurantId)
                                      .content(content)
                                      .score(score)
                                      .createdAt(ZonedDateTime.now())
                                      .build();
    reviewRepository.save(review);
  }

  @Transactional
  public void deleteReview(Long reviewId) {

    ReviewEntity review = reviewRepository.findById(reviewId).orElseThrow();
    reviewRepository.delete(review);
  }
}
