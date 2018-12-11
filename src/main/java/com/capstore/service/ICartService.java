package com.capstore.service;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;

public interface ICartService {

	Cart addProductToCart(CartProduct cartProduct, Integer custId);
	Cart deleteProductFromCart(Integer customerId, Integer productId);
	Cart getCartProducts(Integer customerId);

	public double calculateTotalCartAmount(Cart cart);
	
}