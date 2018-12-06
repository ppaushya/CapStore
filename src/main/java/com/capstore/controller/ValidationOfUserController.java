package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Customer;
import com.capstore.model.Email;
import com.capstore.model.Merchant;
import com.capstore.service.ICustomerService;
import com.capstore.service.IEmailService;
import com.capstore.service.ILoginService;
import com.capstore.service.IMerchantService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ValidationOfUserController {
	
	@Autowired
	IEmailService emailService;
	
	@Autowired
	IMerchantService merchantService;
	
	@Autowired
	ICustomerService customerService;
	
	//customer validation!!
	@PostMapping("/sendVerificationMail")
	public ResponseEntity<Boolean> sendVerificationMail(@RequestBody Customer customer){
		
		customerService.createCustomer(customer);
		
		Email mail=new Email();
		mail.setReceiverEmailId(customer.getEmailId());
		mail.setMessage("Verify by clicking this link");
		mail.setImageUrl(null);
		emailService.sendEmail(mail);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	@RequestMapping("/emailVerificationDone")
	public ResponseEntity<Boolean> emailVerificationDone(HttpSession session){
		
		String customerEmail=(String) session.getAttribute("emailId");
		Customer customer=customerService.getCustomerByEmail(customerEmail);
		
		customer.setVerified(true);
		customerService.updateCustomer(customer);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	//merchant validation!!
	@RequestMapping("/merchantVerification/{merchantMail}")
	public ResponseEntity<Boolean> merchantVerification(@PathVariable("merchantMail") String merchantMail){
		
		Merchant merchant=merchantService.getMerchantByMail(merchantMail);
		
		merchant.setVerified(true);
		merchantService.updateMerchant(merchant);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}
	
	
	@PostMapping("/youMail/email")
	public ResponseEntity<List<Email>> sendVerificationToMail(@RequestBody Email email)
	{
		String emailId=email.getReceiverEmailId();
		System.out.println(emailId);
		List<Email> emails=emailService.getEmails(emailId);
		return new ResponseEntity<List<Email>>(emails, HttpStatus.OK);
		
	}

}
