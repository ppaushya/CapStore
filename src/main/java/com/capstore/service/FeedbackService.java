package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IFeedbackDao;
import com.capstore.model.Feedback;

@Service("feedbackService")
public class FeedbackService implements IFeedbackService{

	@Autowired
	private IFeedbackDao feedbackDao;
	
	@Override
	public void submitFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
	}

	@Override
	public double calculateProductRating(int productId) {
		
		double averageRating = 0;
		int sum=0;
		int feedbacksNumber=0;
		
		List<Feedback> feedbacks = feedbackDao.findAll();
		
		for(Feedback myFeedback:feedbacks) {
			if(myFeedback.getProductId() == productId) {
				
				sum += myFeedback.getRatingProduct();
				feedbacksNumber++;
			}
		}
		
		if(feedbacksNumber!=0) {
			averageRating = (double)(sum/feedbacksNumber);
		}
		
		return averageRating;
	}

	@Override
	public double calculateMerchantRating(int merchantId) {
		
		double averageRating = 0;
		int sum=0;
		int feedbacksNumber=0;
		
		List<Feedback> feedbacks = feedbackDao.findAll();
		
		for(Feedback myFeedback:feedbacks) {
			if(myFeedback.getMerchantId() == merchantId) {
				
				sum += myFeedback.getRatingMerchant();
				feedbacksNumber++;
			}
		}
		
		if(feedbacksNumber!=0) {
			averageRating = (double)(sum/feedbacksNumber);
		}
		
		return averageRating;
	}

}