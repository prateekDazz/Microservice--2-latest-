package com.example.Company.MicroService.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.Company.MicroService.company.CompanyService;
@Service
public class RabbitMQConsumer {
	
	
	private final CompanyService companyService;

	public RabbitMQConsumer(CompanyService companyService) {
		super();
		this.companyService = companyService;
	}
    @RabbitListener(queues = "companyRatingQueue")

	public void consumeMessage(ReviewMessage reviewMessage) throws IllegalAccessException
	{
		System.out.println("consumer call hua");
		companyService.updateCompanyMessage(reviewMessage);
	}

}
