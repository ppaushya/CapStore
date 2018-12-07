package com.capstore.service;

import com.capstore.model.Merchant;

public interface IMerchantService {

	public void addMerchant(Merchant merchant);

	public void deleteMerchant(Integer merchantId);

	public Merchant getMerchantByMail(String merchantMail);

	public void updateMerchant(Merchant merchant);
	
	public double getMerchantRating(int merchantId);
	
	public String getMerchantName(int merchantId);
}
