package com.capstore.controller;

import java.util.List;

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
import com.capstore.service.CustomerService;
import com.capstore.service.ICustomerService;
import com.capstore.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class RegisterController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@PostMapping(value="/createcustomers")
	public ResponseEntity<List<Customer>> createCustomer(@RequestBody Customer customer, HttpSession session){
		System.out.println(session.getAttribute("emailId"));
        List<Customer> customers=customerService.createCustomer(customer);
        
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);		


	}

}
