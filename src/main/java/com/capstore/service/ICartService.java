package com.capstore.service;

import java.util.List;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.model.Product;

public interface ICartService {

	Cart addProductToCart(CartProduct cartProduct, Integer cartId);

	Cart deleteProductFromCart(Integer customerId, Integer productId);

	

}