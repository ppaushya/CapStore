package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstore.model.Promos;

@Transactional
@Repository("promoDao")
public interface IPromoDao extends JpaRepository<Promos,Integer>{

	Promos getById(int promoId);

	//@Query("select discount from Promo where  ")
	


}
