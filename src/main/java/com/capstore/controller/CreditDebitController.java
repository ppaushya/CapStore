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
import com.capstore.model.CreditDebit;
import com.capstore.model.Login;
import com.capstore.service.ICreditDebitService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CreditDebitController {
	
	@Autowired
	private ICreditDebitService creditDebitService;

	@PostMapping("/saveCard")
	public ResponseEntity<String> saveCard(@RequestBody CreditDebit card ){
		if(creditDebitService.saveCard(card))	{
		
		return new ResponseEntity<String>("Card Added Successfully!", HttpStatus.OK);
		}
		else
			return new ResponseEntity("sorry!card insertion failed",HttpStatus.NOT_FOUND);	
	}
	
	@GetMapping("/getcards")
	public ResponseEntity<List<CreditDebit>> getCard(){
		
		List<CreditDebit> cards=creditDebitService.getAllCards();
		if(cards.isEmpty()) {
			return new ResponseEntity("Sorry!No cards available",HttpStatus.NOT_FOUND);	
		}
		else {
			return new ResponseEntity<List<CreditDebit>>(cards, HttpStatus.OK);
		}
	}
	
	@GetMapping("/getcardfromcardnumber/{cardNumber}")
		public ResponseEntity<CreditDebit> getCardFromCardNumber(@PathVariable String cardNumber){
			CreditDebit creditDebit=creditDebitService.getCreditDebitFromCardNumber(cardNumber);
			if(creditDebit==null) {
				return new ResponseEntity("Sorry! Card does not exist!",HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<CreditDebit>(creditDebit,HttpStatus.OK);
		}
	
	@PostMapping("/depositAmount1")
	public ResponseEntity<String> depositAmount(@RequestBody CreditDebit card, @RequestBody double amount) {
		creditDebitService.depositAmount(amount, card);
		return new ResponseEntity<String>("Amount deposited Successfully!", HttpStatus.OK);
	}
	
	@PostMapping("/withdrawAmount1")
	public ResponseEntity<String> withdrawAmount(@RequestBody CreditDebit card, @RequestBody double amount) {
		if (amount > card.getBalance()) {
			return new ResponseEntity<String>("Insufficient Balance!", HttpStatus.NOT_FOUND);
		}
		creditDebitService.withdrawAmount(amount, card);
		return new ResponseEntity<String>("Amount withdrawn Successfully!", HttpStatus.OK);
	}
	
}
