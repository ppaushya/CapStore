package com.capstore.service;

import com.capstore.model.Feedback;

public interface IFeedbackService {

	public void submitFeedback(Feedback feedback);
	
	public double calculateProductRating(int productId);
	
	public double calculateMerchantRating(int merchantId);

}
