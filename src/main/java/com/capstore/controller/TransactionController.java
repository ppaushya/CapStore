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

import com.capstore.model.BankAccount;
import com.capstore.model.CreditDebit;
import com.capstore.model.Invoice;
import com.capstore.model.Transaction;
import com.capstore.service.IBankAccountService;
import com.capstore.service.ICreditDebitService;
import com.capstore.service.IInvoiceService;
import com.capstore.service.IOrderService;
import com.capstore.service.ITransactionService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class TransactionController {

	@Autowired
	ITransactionService transactionService;
	
	@Autowired
	IBankAccountService bankAccountService;
	
	@Autowired
	ICreditDebitService creditDebitService;
	
	@Autowired
	IInvoiceService invoiceService;
	
	@Autowired
	IOrderService orderService;
	
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
	
	@PostMapping("/transaction/order/{orderId}/pay/bankaccount/{amount}")
	public ResponseEntity<String> payByNetBanking(@RequestBody BankAccount account,@PathVariable double amount,@PathVariable int orderId) {//Team 6
		BankAccount bankAccount = bankAccountService.getBankAccountFromUserNamePassword(account.getUserName(), account.getUserPassword());
		if (bankAccount==null) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity("Sorry! No such user exists!", HttpStatus.NOT_FOUND);
		}
		if(!bankAccountService.withdrawAmount(amount, account)) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Error occured", HttpStatus.OK);
		}
		
		if(!bankAccountService.depositAmount(amount, bankAccountService.getCapstoreBankAccount())) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Error occured", HttpStatus.OK);
		}
		
		Transaction transaction = new Transaction();
		transaction.setModeOfPayment("net banking");
		transaction.setPaymentModeNumber(account.getAccountNumber());
		transaction.setStatus("success");
		
		//Invoice invoice = invoiceService.insertInvoiceUsingOrderAndReturn(invoice);
		Invoice invoice = new Invoice();
		
		transaction.setInvoice(invoice);
		transactionService.insertTransaction(transaction);
		
		return new ResponseEntity<String>("Transaction successful!", HttpStatus.OK);
	}
	
	@PostMapping("/transaction/order/{orderId}/pay/card/{amount}")
	public ResponseEntity<String> payByCard(@RequestBody CreditDebit creditDebit,@PathVariable double amount,@PathVariable int orderId) {//Team 6
		if(!creditDebitService.isValidCard(creditDebit)) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Invalid card", HttpStatus.OK);
		}
		CreditDebit card = creditDebitService.getCardFromCardNumber(creditDebit.getCardNumber());
		if (card==null) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Invalid card", HttpStatus.OK);
		}
		if(!creditDebitService.withdrawAmount(amount, card)) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Error occured", HttpStatus.OK);
		}
		
		if(!bankAccountService.depositAmount(amount, bankAccountService.getCapstoreBankAccount())) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Error occured", HttpStatus.OK);
		}
		
		Transaction transaction = new Transaction();
		transaction.setModeOfPayment("card");
		transaction.setPaymentModeNumber(card.getCardNumber());
		transaction.setStatus("success");
		
		//Invoice invoice = invoiceService.insertInvoiceUsingOrderAndReturn(invoice);
		Invoice invoice = new Invoice();
		
		transaction.setInvoice(invoice);
		transactionService.insertTransaction(transaction);
		
		return new ResponseEntity<String>("Transaction successful!", HttpStatus.OK);
	}
	
	@PostMapping("/transaction/order/{orderId}/pay/cash/{amount}")
	public ResponseEntity<String> payByCard(@PathVariable double amount,@PathVariable int orderId) {//Team 6
		if(!bankAccountService.depositAmount(amount, bankAccountService.getCapstoreBankAccount())) {
			orderService.deleteOrder(orderId);
			return new ResponseEntity<String>("Error occured", HttpStatus.OK);
		}
		
		Transaction transaction = new Transaction();
		transaction.setModeOfPayment("cash");
		transaction.setPaymentModeNumber(0);
		transaction.setStatus("success");
		
		//Invoice invoice = invoiceService.insertInvoiceUsingOrderAndReturn(invoice);
		Invoice invoice = new Invoice();
		
		transaction.setInvoice(invoice);
		transactionService.insertTransaction(transaction);
		
		return new ResponseEntity<String>("Transaction successful!", HttpStatus.OK);
	}
	
	
}
