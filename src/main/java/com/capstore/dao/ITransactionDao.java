package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Transaction;

@Repository("transactionDao")
@Transactional
public interface ITransactionDao extends JpaRepository<Transaction,Integer> {

}
