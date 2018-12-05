package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICustomerDao;
import com.capstore.model.Customer;

@Service("customerService")
public class CustomerService implements ICustomerService{
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public boolean createCustomer(Customer customer) {
		customerDao.save(customer);
		return true;
	}
}
