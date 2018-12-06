package com.capstore.service;

import java.util.List;

import com.capstore.model.Customer;

public interface ICustomerService {

	public boolean createCustomer(Customer customer);

	public Customer getCustomerByEmail(String customerEmail);
	public List<Customer> getAllCustomers();
	public Customer getCustomerByCustomerId(int customerId);
	public void updateCustomer(Customer customer);
	
	
}
