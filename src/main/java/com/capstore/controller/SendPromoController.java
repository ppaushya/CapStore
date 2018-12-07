package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.service.ISendPromoService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class SendPromoController {

	
	@Autowired
	private ISendPromoService sendPromoService;
	
@PostMapping("/sendpromoemail")
public ResponseEntity<String> sendPromoEmails(){
	if(sendPromoService.sendPromotionalEmailsToAllCustomer()) {
		return new ResponseEntity<String>("Promo emails sent successfully!",HttpStatus.OK);
    		
	}
	return new ResponseEntity<String>("Promo emails not sent!",HttpStatus.NOT_FOUND);
}
	
	
}

