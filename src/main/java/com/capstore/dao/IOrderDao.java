package com.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstore.model.Order;

public interface IOrderDao extends JpaRepository<Order, Integer> {

}
