package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Transaction;
import com.capstore.service.ITransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	@Autowired
	ITransactionService transactionService;
	
	@GetMapping("/transaction")
	public ResponseEntity<List<Transaction>> getAllTransactions(HttpSession session) {//Team 6
		List<Transaction> transactions = transactionService.getAllTransactions();
		if(transactions.isEmpty()) {
			return new ResponseEntity("Transactions not found", HttpStatus.OK);
		}
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@GetMapping("/transaction/{transactionId}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable("transactionId") Integer transactionId) {//Team 6
		Transaction transaction = transactionService.getTransaction(transactionId);
		if (transaction == null)
			return new ResponseEntity("Sorry! Transaction is not available!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
	}

	@PostMapping("/transaction")
	public ResponseEntity<String> insertTransaction(@RequestBody Transaction transaction) {//Team 6
		if (transactionService.insertTransaction(transaction)) {
			return new ResponseEntity("Transaction inserted", HttpStatus.OK);
		} else {
			return new ResponseEntity("Transaction insertion failed", HttpStatus.OK);
		}
	}
	
	@PutMapping("/transaction")
	public ResponseEntity<String> updateTransaction(@RequestBody Transaction transaction) {//Team 6
		if (transactionService.updateTransaction(transaction)) {
			return new ResponseEntity("Transaction updated", HttpStatus.OK);
		} else {
			return new ResponseEntity("Transaction update failed", HttpStatus.OK);
		}
	}
}
