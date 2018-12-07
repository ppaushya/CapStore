package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICartDao;
import com.capstore.model.Cart;

@Service("cartService")
public class CartService implements ICartService {

	@Autowired
	ICartDao cartDao;

	@Override
	public List<Cart> deleteCartProduct(int cartId) {
		cartDao.deleteById(cartId);
		return cartDao.findAll();
	}

	@Override
	public List<Cart> addCartProduct(Cart cartProduct) {
		cartDao.save(cartProduct);
		System.out.println("vcb");
		return cartDao.findCartByCustomerIdCustomerId(cartProduct.getCustomer().getCustomerId());
	}

	@Override
	public List<Cart> getCartProducts(int custId) {
		return cartDao.findCartByCustomerIdCustomerId(custId);
	}

	@Override
	public void deleteCartAfterOrder(int custId) {
		cartDao.deleteCartAfterOrder(custId);
		
	}

}
