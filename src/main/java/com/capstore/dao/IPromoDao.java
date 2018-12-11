package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstore.model.Promos;

@Transactional
@Repository("promoDao")
public interface IPromoDao extends JpaRepository<Promos,Integer>{

	Promos getById(int promoId);

	//@Query("select discount from Promo where  ")
	

=======
import org.springframework.stereotype.Repository;

import com.capstore.model.Promos;


@Repository("promoDao")
@Transactional
public interface IPromoDao extends JpaRepository<Promos, Integer>{
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git

}
