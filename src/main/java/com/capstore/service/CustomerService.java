package com.capstore.service;

import java.util.List;

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

	@Override
	public Customer getCustomerByEmail(String customerEmail) {
		return customerDao.getByEmailId(customerEmail);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDao.findAll();
	}
}
