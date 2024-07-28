package com.example.Review.MicroService.review;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.Review.MicroService.messaging.ReviewMessageProducer;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {
	private ReviewRepository reviewRepository;
	

	@Override
	public List<Review> getAllReviewsForCompanyId(long companyId) {

//		Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotExistsException(
//				"The company with the mentioned id ::" + companyId + " does not exists"));
//		List<Review> reviewList = company.getReviews();

		List<Review> reviewList = reviewRepository.findByCompanyId(companyId);
		return reviewList;
	}

	@Override
	public Review saveAllReviewForCompanyId( ReviewRequestDto reviewRequestDto) {
//		Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotExistsException(
//				"The company with the mentioned id ::" + companyId + " does not exists"));
		Review review = new Review();
		review.setCompanyId(reviewRequestDto.getCompanyId());
		review.setDescription(reviewRequestDto.getDescription());
		review.setRating(reviewRequestDto.getRating());
		review.setTitle(reviewRequestDto.getTitle());
		Review savedReview = reviewRepository.save(review);
		return review;
	}

	@Override
	public Review getReviewByReviewId( long reviewId) {
//		Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotExistsException(
//				"The company with the mentioned id ::" + companyId + " does not exists"));
//		Review review = company.getReviews().stream().filter(rev -> rev.getId() == reviewId).findFirst().orElseThrow(
//				() -> new ReviewNotExistsException("The review with given id ::" + reviewId + " does not exists"));
//		List<Review>review  = reviewRepository.findByCompanyId(companyId);
//Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new IllegalArgumentException("Review with ID ::"+reviewId+" is not found "));
//		Review finalReview  = review.stream().filter(r->r.getId()==reviewId).findFirst().orElseThrow(()-> new IllegalArgumentException("no such review exist"));
		Review finalReview = reviewRepository.findById(reviewId).orElseThrow(()->new IllegalArgumentException("review with id "+reviewId+"does not exists"));
		return finalReview;
	}

	@Override
	public Review updateReview(long reviewId, ReviewRequestDto reviewRequestDto) {
//		Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotExistsException(
//				"The company with the mentioned id ::" + companyId + " does not exists"));
//		Review review = company.getReviews().stream().filter(rev -> rev.getId() == reviewId).findFirst().orElseThrow(
//				() -> new ReviewNotExistsException("The review with given id ::" + reviewId + " does not exists"));
//		List<Review> savedReviewList = company.getReviews();
//		boolean removeFlag = savedReviewList.remove(review);
//		savedReviewList.remove(review);

//		System.out.println("the value pf remove flag is " + removeFlag);
		Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new IllegalArgumentException("Review with ID ::"+reviewId+" is not found "));

	
		review.setDescription(reviewRequestDto.getDescription());
		review.setRating(reviewRequestDto.getRating());
		review.setTitle(reviewRequestDto.getTitle());
//		savedReviewList.add(review);
		reviewRepository.save(review);
//		company.setReviews(savedReviewList);
//		companyRepository.save(company);
		return review;

	}

	@Override
	public Review delete( long reviewId) {
//		Company company = companyRepository.findById(companyId).orElseThrow(() -> new CompanyNotExistsException(
//				"The company with the mentioned id ::" + companyId + " does not exists"));
//		Review review = company.getReviews().stream().filter(rev -> rev.getId() == reviewId).findFirst().orElseThrow(
//				() -> new ReviewNotExistsException("The review with given id ::" + reviewId + " does not exists"));
//		List<Review> savedReviewList = company.getReviews();
//		boolean removeFlag = savedReviewList.remove(review);
//		savedReviewList.remove(review);

		Review review = reviewRepository.findById(reviewId).orElseThrow(()-> new IllegalArgumentException("Review with ID ::"+reviewId+" is not found "));
reviewRepository.delete(review);
//		System.out.println("the value pf remove flag is " + removeFlag);
//
//		company.setReviews(savedReviewList);
//		companyRepository.save(company);
		return review;
	}

	@Override
	public List<Review> getAllReviews() {
List<Review>reviewList = reviewRepository.findAll();
		return reviewList;
	}

}
