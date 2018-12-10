package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICartDao;
import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.model.Product;

@Service("cartService")
public class CartService implements ICartService {

	@Autowired
	ICartDao cartDao;

	@Override
	public Cart addProductToCart(CartProduct cartProduct, Integer custId) {
		Cart cart=cartDao.getOne(custId);
		
		if(cart==null)
		{
			
			cart.getCartProducts().add(cartProduct);
		}
		else
		{
			
		}
		return null;
	}

	

}
