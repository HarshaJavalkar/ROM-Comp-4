package com.returnordermanag.componentProcessModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanag.componentProcessModule.client.PaymentFeignClient;
import com.returnordermanag.componentProcessModule.model.Payment;
import com.returnordermanag.componentProcessModule.repository.PaymentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PaymentFeignClient paymentFeignClient;

	public String completeProcessing(int requestID, long creditCardNumber, double creditLimit,
			double processingCharge) {
		log.info("Inside Payment Service");

		double currentBalance = -1;
		String finalResponse = "";

		Payment payment = new Payment();
		payment.setRequestID(requestID);
		payment.setCreditCardNumber(creditCardNumber);
		payment.setCreditLimit(creditLimit);
		payment.setProcessingCharge(processingCharge);
		paymentRepository.save(payment);

		log.info("Invoking Payment Microservice");
		currentBalance = paymentFeignClient.getCurrentBalance(creditCardNumber, processingCharge);
//		currentBalance=500;
		log.info("Current Balance remaining calculated");

		if (currentBalance <= -1)
			finalResponse = "DE-100";
		else
			finalResponse = "DE-200";
		return finalResponse;
	}

}
