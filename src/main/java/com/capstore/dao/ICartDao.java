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

	@Query("from Cart  where customer_customer_id=:custId")
	public List<Cart> findCartByCustomerIdCustomerId(@Param("custId") Integer custId);
	
	/*@Query("delete from cart c where c.customer_customer_id=:custId")
	public void deleteCartAfterOrder(int custId);*/
}
