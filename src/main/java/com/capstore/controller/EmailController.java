package com.capstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Customer;
import com.capstore.model.Email;
import com.capstore.service.ICustomerService;
import com.capstore.service.IEmailService;
import com.capstore.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class EmailController {
	
	@Autowired
	IEmailService emailService;
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/sendVerificationMail")
	public ResponseEntity<Boolean> sendVerificationMail(@RequestBody Customer customer){
		
		customerService.addCustomer(customer);
		
		Email mail=new Email();
		mail.setEmailId(customer.getEmailId());
		mail.setMessage("Verify by clicking this link");
		mail.setImageUrl(null);
		emailService.sendEmail(mail);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@RequestMapping("/emailVerificationDone")
	public ResponseEntity<Boolean> emailVerificationDone(){
		
		
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	

}
