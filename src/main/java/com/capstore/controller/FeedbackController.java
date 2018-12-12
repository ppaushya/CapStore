package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Feedback;
import com.capstore.service.ICustomerService;
import com.capstore.service.IFeedbackService;
import com.capstore.service.IMerchantService;
import com.capstore.service.IProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class FeedbackController {
	
	@Autowired
	IFeedbackService feedbackService;
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IMerchantService merchantService;
	
	@PostMapping("/feedback/{customerId}/{merchantId}/{productId}")
	public ResponseEntity<Boolean> submitFeedback(
			@PathVariable("customerId")int customerId, @PathVariable("merchantId") int merchantId,
			@PathVariable("productId") int productId){
		Feedback feedback = new Feedback();
		   feedback.setCustomer(customerService.getCustomerByCustomerId(customerId));
		   feedback.setMerchant(merchantService.getMerchantByMerchantId(merchantId));
		   feedback.setProduct(productService.getProduct(productId));
		
		feedbackService.submitFeedback(feedback);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);

	}
}