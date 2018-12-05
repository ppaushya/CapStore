package com.capstore.dao;

<<<<<<< HEAD
import java.util.List;
=======
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Email;

@Repository("emailDao")
@Transactional
public interface IEmailDao extends JpaRepository<Email,Integer>  {
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstore.model.Customer;
import com.capstore.model.Email;
@Repository("emailDao")
@Transactional
public interface IEmailDao extends JpaRepository<Email, Integer>{

	@Query("from Customer")
	public List<Customer> getCustomerList();

	
}
