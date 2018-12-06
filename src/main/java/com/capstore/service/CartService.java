package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICartDao;
import com.capstore.model.Cart;

@Service("cartService")
public class CartService implements ICartService{

	@Autowired
	ICartDao cartDao;
	
	
	@Override
	public List<Cart> deleteCartProduct(int productId) {
		cartDao.deleteById(productId);
		return cartDao.findAll();
		
	}


	@Override
	public void deleteCartAfterOrder(int custId) {
		cartDao.deleteCartAfterOrder(custId);
		
	}

}
