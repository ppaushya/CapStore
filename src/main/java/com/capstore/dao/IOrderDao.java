package com.capstore.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capstore.model.Order;

public interface IOrderDao extends JpaRepository<Order, Integer> {
	
	@Query("from Order WHERE  customer.customerId=:custId")
	public List<Order> getOrdersForCustomer(@Param("custId") int custId);
	
	@Query("from Order WHERE orderDate BETWEEN :fromDate AND :toDate")
	public List<Order> getOrdersBetween(Date fromDate, Date toDate);
}
