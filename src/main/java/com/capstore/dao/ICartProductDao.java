package com.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;


@Repository("cartProductDao")
@Transactional
public interface ICartProductDao extends JpaRepository<CartProduct, Integer> {
	
	//@Query("")
	

}
