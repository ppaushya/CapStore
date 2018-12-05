package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICustomerDao;
import com.capstore.model.Customer;

@Service("customerService")
public class CustomerService implements ICustomerService{
	
	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public void addCustomer(Customer customer) {
		customer.setVerified(false);
		customerDao.save(customer);
	}
}
