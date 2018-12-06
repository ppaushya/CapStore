package com.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capstore.model.BankAccount;

@Repository("bankAccountDao")
@Transactional
public interface IBankAccountDao extends JpaRepository<BankAccount, String>{
	
	@Query("from BankAccount where userName=:uname and userPassword=:upwd")
	public List<BankAccount> getBankAccountFromUserNamePassword(@Param("uname") String userName, @Param("upwd")String userPassword);

}
