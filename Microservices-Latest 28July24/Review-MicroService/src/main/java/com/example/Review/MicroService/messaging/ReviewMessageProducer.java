package com.example.Review.MicroService.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Review.MicroService.review.Review;

@Component
public class ReviewMessageProducer {
	private final RabbitTemplate rabbitTemplate;

	public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
		super();
		this.rabbitTemplate = rabbitTemplate;
	}
	public void sendMessage(Review review)
	{
		ReviewMessage reviewMessage = new ReviewMessage();
		reviewMessage.setId(review.getId());
		reviewMessage.setCompanyId(review.getCompanyId());
		
		reviewMessage.setDescription(review.getDescription());
		reviewMessage.setRating(review.getRating());
		reviewMessage.setTitle(review.getTitle());
		rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessage);
	}

}
