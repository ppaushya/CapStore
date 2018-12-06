package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IBankAccountDao;
import com.capstore.model.BankAccount;

@Service("bankAccountService")
public class BankAccountService implements IBankAccountService {

	@Autowired
	private IBankAccountDao bankAccountDao;

	@Override
	public boolean addBankAccount(BankAccount bankAccount) {
		bankAccountDao.save(bankAccount);
		return true;
	}

	@Override
	public List<BankAccount> getAllBankAccounts() {

		return bankAccountDao.findAll();
	}

	@Override
	public List<BankAccount> getBankAccountFromUserNamePassword(String userName, String userPassword) {

		return bankAccountDao.getBankAccountFromUserNamePassword(userName, userPassword);
	}
	
	@Override
	public void depositAmount(double amount, BankAccount bankAccount) {
		double finalAmount = bankAccount.getBalance() + amount;
		bankAccountDao.updateAmount(finalAmount, bankAccount.getAccountNumber());
	}

	@Override
	public void withdrawAmount(double amount, BankAccount bankAccount) {
		double finalAmount = bankAccount.getBalance() - amount;
		bankAccountDao.updateAmount(finalAmount, bankAccount.getAccountNumber());
	}

}
