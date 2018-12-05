package com.capstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICreditDebitDao;
import com.capstore.model.CreditDebit;


@Service("creditDebitService")
public class CreditDebitService implements ICreditDebitService{

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
	public CreditDebit getCreditDebitFromCardNumber(String cardNumber) {
		Optional<CreditDebit> optional=creditDebitDao.findById(cardNumber);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	

}
