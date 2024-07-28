package com.example.Review.MicroService.review;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Review.MicroService.messaging.ReviewMessageProducer;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@AllArgsConstructor
public class ReviewController {
	private ReviewService reviewService;
	private ReviewMessageProducer reviewMessageProducer;

	@GetMapping
	
	public ResponseEntity<List<Review>>getAllReviewsForCompanyId(@RequestParam("companyId")long companyId)
	{
		List<Review>reviewList =  reviewService.getAllReviewsForCompanyId(companyId);
		return ResponseEntity.ok(reviewList);
	}
	
@GetMapping("/getAllReviews")
	
	public ResponseEntity<List<Review>>getAllReviews()
	{
		List<Review>reviewList =  reviewService.getAllReviews();
		return ResponseEntity.ok(reviewList);
	}
@PostMapping
public ResponseEntity<Review>saveReview(@RequestBody ReviewRequestDto reviewRequestDto)
{
	Review review  =  reviewService.saveAllReviewForCompanyId( reviewRequestDto);
	if(review !=null)
	{
		reviewMessageProducer.sendMessage(review);
	}
	return ResponseEntity.ok(review);
}
@GetMapping("/{reviewId}")
public ResponseEntity<Review>getReviewByReviewId(@PathVariable("reviewId")long reviewId)
{
	Review review  =  reviewService.getReviewByReviewId(reviewId);
	return ResponseEntity.ok(review);
}
@PutMapping("/{reviewId}")
public ResponseEntity<Review>updateReview(@PathVariable("reviewId")long reviewId,@RequestBody ReviewRequestDto reviewRequestDto)
{
	Review review  =  reviewService.updateReview( reviewId,reviewRequestDto);
	return ResponseEntity.ok(review);
}
@DeleteMapping("/{reviewId}")
public ResponseEntity<Review>deleteReview(@PathVariable("reviewId")long reviewId)
{
	Review review  =  reviewService.delete( reviewId);
	return ResponseEntity.ok(review);
}
@GetMapping("/averageRating")
public Double getAverageReview(@RequestParam("companyId")long companyId)
{
	List<Review>reviewList = reviewService.getAllReviewsForCompanyId(companyId);
	return reviewList.stream().mapToDouble(r->r.getRating()).average().orElse(0.0);
}

}
