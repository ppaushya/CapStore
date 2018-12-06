package com.capstore.service;

import java.util.List;

import com.capstore.model.CreditDebit;

public interface ICreditDebitService {

	public boolean saveCard(CreditDebit creditDebit);
	public List<CreditDebit> getAllCards();
	public CreditDebit getCreditDebitFromCardNumber(String cardNumber);
	
}
