package com.capstore.service;

import java.util.List;

import com.capstore.model.Order;
import com.capstore.model.Product;

public interface IOrderService {

	public List<Product> displayCartProducts(int orderId);

	public boolean checkAvailabilityInInventory(Order order);
	public boolean placeOrderAndUpdateInventory(Order order);
	
	public Order findOrderById(int orderId);

}
