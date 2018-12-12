package com.capstore.service;

import java.util.List;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.model.Product;

public interface ICartService {

	
	
	
	Cart addProductToCart(CartProduct cartProduct, String customerEmailId);

	Cart deleteProductFromCart(String customerEmailId, Integer productId);

	Cart getCartProducts(String customerEmailId);

	Cart updateCartProductQuantity(CartProduct cartProduct, String customerEmailId);

	

}