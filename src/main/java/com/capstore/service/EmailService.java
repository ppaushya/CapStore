package com.capstore.service;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IEmailDao;
import com.capstore.model.Customer;
import com.capstore.model.Email;

@Service("emailService")
public class EmailService implements IEmailService{

	@Autowired
<<<<<<< HEAD
	private IEmailDao emailDao;

	@Override
	public void sendEmailToCustomer(Email email) {
		
		emailDao.save(email);
		
	}

	@Override
	public List<Customer> getCustomerList() {
		
		return emailDao.getCustomerList();
=======
	IEmailDao emailDao;
	
	@Override
	public void sendEmail(Email mail) {
		emailDao.save(mail);
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
	}

}
