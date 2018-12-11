package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICartDao;
import com.capstore.dao.ICartProductDao;
import com.capstore.dao.ICustomerDao;
import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.model.Customer;
import com.capstore.model.Product;

@Service("cartService")
public class CartService implements ICartService {

	@Autowired
	ICartDao cartDao;
	
	@Autowired
	ICustomerDao customerDao;
	
	@Autowired
	ICartProductDao cartProductDao;
	
	

	@Override
	public Cart addProductToCart(CartProduct cartProduct, Integer custId) {
		
		Customer customer=customerDao.getOne(custId);
		System.out.println(customer);
		
		Cart cart=cartDao.findByCustomer(custId);
		
		if(cart==null)
		{
			
			cart=new Cart();
			
			cart.setCustomer(customer);
			System.out.println(cartProduct);
			cartProductDao.save(cartProduct);
			
			cart.getCartProducts().add(cartProduct);
			cart.setMinimumAmount(100);
			
			
			cartDao.save(cart);
		}
		else
		{
			List<CartProduct> cartProducts=cart.getCartProducts();
			
			for(CartProduct cartProduct1:cartProducts)
			{
				
				//if the product already exists
				if(cartProduct1.getProduct().equals(cartProduct.getProduct()))
				{
					return cart;
				}
			}
			
			//save the product in table if it new product is added
			cartProductDao.save(cartProduct);
			
			//add the product to cart table
			cart.getCartProducts().add(cartProduct);
			System.out.println(cart);
			cartDao.save(cart);
			
		}
		return cart;
	}

	

}
