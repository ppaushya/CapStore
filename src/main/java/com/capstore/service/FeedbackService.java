package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IFeedbackDao;
import com.capstore.model.Feedback;

@Service("feedbackService")
public class FeedbackService implements IFeedbackService{

	@Autowired
	IFeedbackDao feedbackDao;
	
	@Override
	public void submitFeedback(Feedback feedback) {
		feedbackDao.save(feedback);
	}

}
