package com.capstore.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstore.model.Cart;

@Repository("cartDao")
@Transactional
public interface ICartDao extends JpaRepository<Cart, Integer> {
    
	@Query("from Cart  where customerId=:custId")
	public List<Cart> findCartByCustomerIdCustomerId(@Param("custId") Integer custId);
		
	
}
