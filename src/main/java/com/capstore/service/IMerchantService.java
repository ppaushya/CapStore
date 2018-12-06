package com.capstore.service;

import com.capstore.model.Merchant;

public interface IMerchantService {

	void addMerchant(Merchant merchant);

	void deleteMerchant(Integer merchantId);

	Merchant getMerchantByMail(String merchantMail);

	void updateMerchant(Merchant merchant);
	public String getMerchantName(int merchantId);
}
