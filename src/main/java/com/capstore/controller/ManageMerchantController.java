package com.capstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Merchant;
import com.capstore.service.FeedbackService;
import com.capstore.service.IMerchantService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ManageMerchantController {

	@Autowired
	IMerchantService merchantService;

	public FeedbackService feedbackService;

	@PostMapping("/merchantRegistration")
	public ResponseEntity<Boolean> addMerchant(
			@RequestBody Merchant merchant){
		merchantService.addMerchant(merchant);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@DeleteMapping("/merchants/{merchantId}")
	public ResponseEntity<Boolean> deleteMerchant(@PathVariable Integer merchantId){

		merchantService.deleteMerchant(merchantId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}

	@GetMapping("/merchants/{merchantId}")
	public ResponseEntity<Double> getMerchantRating(@PathVariable int merchantId) {

		double avgMerchantRating=merchantService.getMerchantRating(merchantId);

		return new ResponseEntity<Double>(avgMerchantRating,HttpStatus.OK);

	}

	@PostMapping("/passwordMatch")
	public ResponseEntity<Boolean> passwordMatch(@RequestBody String pasword,HttpSession session) {


		String merchantMail=(String) session.getAttribute("emailId");
		Merchant merchant=merchantService.getMerchantByMail(merchantMail);
		if(merchant.getPassword().equals(pasword)) {
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}



	}

	@PostMapping("/passwordChange")
	public ResponseEntity<Boolean> passwordChange(@RequestBody String password,HttpSession session) {


		String merchantMail=(String) session.getAttribute("emailId");
		Merchant merchant=merchantService.getMerchantByMail(merchantMail);
		merchant.setPassword(password);
		merchantService.updateMerchant(merchant);
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);




	}

	@GetMapping("/destroySession")
	public ResponseEntity<Boolean> destroySession(HttpSession session) {
		session.invalidate();

		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
	}




}
