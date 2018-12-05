package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Customer;

@Repository("customerDao")
@Transactional
public interface ICustomerDao extends JpaRepository<Customer,Integer> {


	Customer getByEmailId(String customerEmail);


}
