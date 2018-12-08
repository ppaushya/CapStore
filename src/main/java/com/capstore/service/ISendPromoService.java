package com.capstore.service;

import java.util.List;

import com.capstore.model.Email;
import com.capstore.model.Product;

public interface ISendPromoService {

	public boolean sendPromotionalEmailToUser(Email email);
	public boolean sendPromotionalEmailsToAllCustomer();
	public boolean checkIfPromotionalEmailsRequiredToBeSent();
	public Email getNewProductEmail(List<Product> products);
	public boolean markPromotionalEmailsSent(List<Product> products);
}
