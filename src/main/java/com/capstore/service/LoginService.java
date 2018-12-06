package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ILoginDao;
import com.capstore.model.Customer;
import com.capstore.model.Login;


@Service("loginService")
public class LoginService implements ILoginService{
	
@Autowired
	private ILoginDao loginDao;
	
	@Override
	public Login getLogin(String emailId, String password) {
		// TODO Auto-generated method stub
		Login login=loginDao.getByEmailIdAndPassword( emailId, password);
		System.out.println(login);
		return login;
	}

	@Override
	public Customer getCustomerId(String emailId) {
		System.out.println( loginDao.getByEmailId(emailId));
		return loginDao.getByEmailId(emailId);
		
	}
}
