package com.example.Review.MicroService.review;

import java.util.List;

public interface ReviewService {
	
	public List<Review> getAllReviewsForCompanyId(long companyId);
	public Review saveAllReviewForCompanyId(ReviewRequestDto reviewRequestDto);
	public Review getReviewByReviewId(long ReviewId);
	public Review updateReview(long ReviewId,ReviewRequestDto reviewRequestDto);
	public Review delete(long ReviewId);
	public List<Review> getAllReviews();

}
