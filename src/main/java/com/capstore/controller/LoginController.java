package com.capstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capstore.model.Login;
import com.capstore.service.ILoginService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class LoginController {

	
	@Autowired
	private ILoginService loginService;
	
	
	@PostMapping("/validlogin")
	public ResponseEntity<Login> getLogin (@RequestBody Login login, HttpSession session){
		
		//(@RequestBody Login login,
		
		Login loginbean=loginService.getLogin(login.getEmailId(),login.getPassword());
		
		if(loginbean==null)
		{
			return new ResponseEntity("hdjysfgfh",HttpStatus.NOT_FOUND);	
		}
		session.setAttribute("emailId", loginbean.getEmailId());
		return new ResponseEntity<Login>(loginbean,HttpStatus.OK);	
	}
	
	
}