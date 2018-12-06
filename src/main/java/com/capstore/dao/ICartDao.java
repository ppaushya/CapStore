package com.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstore.model.Cart;

@Repository("cartDao")
@Transactional
public interface ICartDao extends JpaRepository<Cart, Integer> {

	@Query("delete from cart c where c.customer.customerId=:custId")
	public void deleteCartAfterOrder(int custId);
}
