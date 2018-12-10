package com.capstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICreditDebitDao;
import com.capstore.model.CreditDebit;

@Service("creditDebitService")
public class CreditDebitService implements ICreditDebitService {

	@Autowired
	private ICreditDebitDao creditDebitDao;

	@Override
	public boolean saveCard(CreditDebit creditDebit) {
		creditDebitDao.save(creditDebit);
		return true;
	}

	@Override
	public List<CreditDebit> getAllCards() {
		return creditDebitDao.findAll();
	}
	
	@Override
	public CreditDebit getCardFromCardNumber(long cardNumber) {
		Optional<CreditDebit> optional = creditDebitDao.findById(cardNumber);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean depositAmount(double amount, CreditDebit creditDebit) {
		CreditDebit card = getCardFromCardNumber(creditDebit.getCardNumber());
		if(card!=null) {
			double finalAmount = card.getBalance() + amount;
			card.setBalance(finalAmount);
			creditDebitDao.save(card);
			return true;
		}
		return false;
	}

	@Override
	public boolean withdrawAmount(double amount, CreditDebit creditDebit) {
		CreditDebit card = getCardFromCardNumber(creditDebit.getCardNumber());
		if(card!=null) {
			double balance = card.getBalance();
			if (amount > balance) {
				return false;
			}
			double finalAmount = balance - amount;
			card.setBalance(finalAmount);
			creditDebitDao.save(card);
			return true;
		}
		return false;
	}

}
