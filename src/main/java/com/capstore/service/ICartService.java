package com.capstore.service;

import java.util.List;

import com.capstore.model.Cart;

public interface ICartService {

	List<Cart> deleteCartProduct(int productId);
	public void deleteCartAfterOrder(int custId);//team 6 

	List<Cart> addCartProduct(Cart cartProduct);

	List<Cart> getCartProducts(int custId);

}