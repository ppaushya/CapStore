package com.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Customer;
import com.capstore.model.Login;

@Repository("customerDao")
@Transactional
public interface ICustomerDao extends JpaRepository<Customer,Integer> {


	
}
