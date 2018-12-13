package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.capstore.model.Customer;
import com.capstore.model.Login;
import com.capstore.model.Merchant;
import com.capstore.service.ICustomerService;
import com.capstore.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CustomerProfileController {
	
	@Autowired
	ICustomerService customerService;
	
	
	@Autowired
	ILoginService loginService;
	
	@GetMapping("/getCustomer/{email}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("email") String email)
	{
		
		Customer customer=customerService.getCustomerByEmail(email);
		System.out.println(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}

	
	
	@PostMapping("/customerPasswordMatch/{email}")
	public ResponseEntity<Boolean> passwordMatch(@RequestBody String password,HttpSession session, @PathVariable("email") String mail) {


		Customer customer=customerService.getCustomerByEmail(mail);
		System.out.println(customer);
		if(customer.getPassword().equals(password)) {
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		}



	}

	@PostMapping("/customerPasswordChange/{email}")
	public ResponseEntity<Boolean> passwordChange(@RequestBody String password, HttpServletRequest request, @PathVariable("email") String mail) {

		
		//String merchantMail=(String) session.getAttribute("email");
		Customer customer=customerService.getCustomerByEmail(mail);
		customer.setPassword(password);
		customerService.updateCustomer(customer);
		Login login=loginService.getLoginByEmailId(mail);
		login.setPassword(password);
		loginService.updateLogin(login);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);




	}
	
	
	

}
