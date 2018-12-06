package com.capstore.service;

import java.util.List;

import com.capstore.model.Order;

public interface IOrderService {

	public List<Order> displayCart();

	public boolean placeOrder(Order order);

}
