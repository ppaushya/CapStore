package com.capstore.service;

import com.capstore.model.Email;

public interface ISendPromoService {

	public boolean sendPromotionalEmailToUser(Email email);
	public boolean sendPromotionalEmailsToAllCustomer();
	public Email getPromotionalEmail();
}
