package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.BankAccount;
import com.capstore.service.IBankAccountService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {

	@Autowired
	private IBankAccountService bankAccountService;

	@PostMapping("/addbankaccount")
	public ResponseEntity<String> addBankAccount(@RequestBody BankAccount bankAccount) {
		if (bankAccountService.addBankAccount(bankAccount)) {
			return new ResponseEntity("Bank Account added successfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity("Sorry! Bank Account insertion failed!", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getallbankaccounts")
	public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
		List<BankAccount> bankAccounts = bankAccountService.getAllBankAccounts();
		if (bankAccounts.isEmpty()) {
			return new ResponseEntity("Sorry! No Saved Bank Accounts!", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<List<BankAccount>>(bankAccounts, HttpStatus.OK);
		}
	}

	@PostMapping("/getbankaccfromusernameandpass")
	public ResponseEntity<BankAccount> getBankAccountFromUserNamePassword(@RequestBody String userName,
			@RequestBody String userPassword) {
		List<BankAccount> bankAccounts = bankAccountService.getBankAccountFromUserNamePassword(userName, userPassword);
		if (bankAccounts.isEmpty()) {
			return new ResponseEntity("Sorry! No such user exists!", HttpStatus.NOT_FOUND);
		}

		BankAccount userAccount = bankAccounts.get(0);
		return new ResponseEntity<BankAccount>(userAccount, HttpStatus.OK);
	}

	@PostMapping("/depositAmount")
	public ResponseEntity<String> depositAmount(@RequestBody BankAccount account, @RequestBody double amount) {
		bankAccountService.depositAmount(amount, account);
		return new ResponseEntity<String>("Amount deposited Successfully!", HttpStatus.OK);
	}

	@PostMapping("/withdrawAmount")
	public ResponseEntity<String> withdrawAmount(@RequestBody BankAccount account, @RequestBody double amount) {
		if (amount > account.getBalance()) {
			return new ResponseEntity<String>("Insufficient Balance!", HttpStatus.NOT_FOUND);
		}
		bankAccountService.withdrawAmount(amount, account);
		return new ResponseEntity<String>("Amount withdrawn Successfully!", HttpStatus.OK);
	}
}
