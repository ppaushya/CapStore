package com.capstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstore.model.Customer;


@Service("customerService")
public class CustomerService implements ICustomerService{

	
	@Override
	public List<Customer> createCustomer(Customer customer) {
		return null;
	}
}
