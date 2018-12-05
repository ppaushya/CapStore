package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Address;
import com.capstore.model.Feedback;
import com.capstore.service.IAddressService;
import com.capstore.service.IFeedbackService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class FeedbackController {
	
	@Autowired
	IFeedbackService feedbackService;
	
	@PostMapping("/feedback")
	public ResponseEntity<Boolean> submitFeedback(
			@RequestBody Feedback feedback){
		
		feedbackService.submitFeedback(feedback);
		return new ResponseEntity<>(true,HttpStatus.OK);

	}
}