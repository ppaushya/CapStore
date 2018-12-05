package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.CreditDebit;

@Repository("creditDebitDao")
@Transactional
public interface ICreditDebitDao  extends JpaRepository<CreditDebit, String>{
		
}
