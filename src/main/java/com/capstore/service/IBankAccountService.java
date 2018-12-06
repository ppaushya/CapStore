package com.capstore.service;

import java.util.List;

import com.capstore.model.BankAccount;

public interface IBankAccountService {
	
	public boolean addBankAccount(BankAccount bankAccount);

	public List<BankAccount> getAllBankAccounts();
	public List<BankAccount> getBankAccountFromUserNamePassword(String userName, String userPassword);
}
