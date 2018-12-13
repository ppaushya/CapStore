package com.capstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.http.Header;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Login;
import com.capstore.model.Merchant;
import com.capstore.service.FeedbackService;
import com.capstore.service.ILoginService;
import com.capstore.service.IMerchantService;

@CrossOrigin(origins="*")
@RestController()
@RequestMapping("/api/v1")
public class ManageMerchantController {

	
	
	@Autowired
	IMerchantService merchantService;
	
	@Autowired
	ILoginService loginService;
	

	public FeedbackService feedbackService;

	@PostMapping("/merchantRegistration")
	public ResponseEntity<Boolean> addMerchant(
			@RequestBody Merchant merchant){
		
		merchantService.addMerchant(merchant);
		return new ResponseEntity<>(true, HttpStatus.OK);
		
		
//		{
//			return new ResponseEntity<>(false, HttpStatus.OK);
//		}
		
	
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

	@PostMapping("/passwordMatch/{email}")
	public ResponseEntity<Boolean> passwordMatch(@RequestBody String pasword,HttpSession session, @PathVariable("email") String mail) {

		
		Login login=loginService.getLoginByEmailId(mail);
		System.out.println(login);
		if(login.getPassword().equals(pasword)) {
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}



	}

	@PostMapping("/passwordChange/{email}")
	public ResponseEntity<Boolean> passwordChange(@RequestBody String password, HttpServletRequest request, @PathVariable("email") String mail) {

		
		//String merchantMail=(String) session.getAttribute("email");
		Merchant merchant=merchantService.getMerchantByMail(mail);
		merchant.setMerchantPassword(password);
		merchantService.updateMerchant(merchant);
		Login login=loginService.getLoginByEmailId(mail);
		login.setPassword(password);
		loginService.updateLogin(login);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);




	}

	




}
