package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IMerchantDao;
import com.capstore.model.Merchant;

@Service("merchantService")
public class MerchantService implements IMerchantService{

	@Autowired
	IMerchantDao merchantDao;
	
	@Autowired
	public FeedbackService feedbackService;

	@Override
	public void addMerchant(Merchant merchant) {
		 merchantDao.save(merchant);
	}

	@Override
	public void deleteMerchant(Integer merchantId) {
		merchantDao.deleteById(merchantId);
		
	}

	@Override
	public Merchant getMerchantByMail(String merchantMail) {
		return merchantDao.getByEmailId(merchantMail);
	}

	@Override
	public void updateMerchant(Merchant merchant) {
		merchantDao.save(merchant);
	}

	@Override
	public double getMerchantRating(int merchantId) {
		
		return feedbackService.calculateMerchantRating(merchantId);
	}

	

	

	
	
	@Override
	public String getMerchantName(int merchantId) {
		Merchant merchant=merchantDao.findById(merchantId).get();
		return merchant.getMerchantName();
	}

	@Override
	public List<Merchant> getAllMerchants() {
		return merchantDao.findAll();
	}
	
}
