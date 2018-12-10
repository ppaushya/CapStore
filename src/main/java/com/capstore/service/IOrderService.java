package com.capstore.service;

import java.util.List;

import com.capstore.model.CartProduct;
import com.capstore.model.Order;

public interface IOrderService {

	public List<CartProduct> displayCartProducts(int orderId);

	public boolean checkAvailabilityInInventory(Order order);
	public boolean placeOrder(Order order);
	public boolean deliverOrderAndUpdateInventory(Order order);
	
	public Order findOrderById(int orderId);
	
	

}
