package com.jiwon.review.repository;

import com.jiwon.review.model.QReviewEntity;
import com.jiwon.review.model.ReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

  private final JPAQueryFactory queryFactory;

  @Override
  public Double getAvgScoreByRestaurantId(Long restaurantId) {
    return queryFactory.select(QReviewEntity.reviewEntity.score.avg())
                       .from(QReviewEntity.reviewEntity)
                       .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                       .fetchFirst();
  }

  @Override
  public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {
    List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                                             .from(QReviewEntity.reviewEntity)
                                             .where(QReviewEntity.reviewEntity.restaurantId.eq(
                                                 restaurantId))
                                             .offset(
                                                 (long) page.getPageNumber() * page.getPageSize()) //몇번 부터 가져와
                                             .limit(page.getPageSize() + 1) //몇 개를 가져와 (다음게 있는지 알려주기 위해 +1을 해줌)
                                             .fetch();
    return new SliceImpl<>(
        reviews.stream().limit(page.getPageSize()).toList(),
        page,
        reviews.size() > page.getPageSize()
    );
  }
}
