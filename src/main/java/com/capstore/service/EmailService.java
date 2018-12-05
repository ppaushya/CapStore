package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IEmailDao;
import com.capstore.model.Customer;
import com.capstore.model.Email;

@Service("emailService")
public class EmailService implements IEmailService{

	@Autowired
	IEmailDao emailDao;
	
	@Override
	public void sendEmail(Email mail) {
		emailDao.save(mail);
	}

}
