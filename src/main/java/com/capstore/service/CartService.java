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
		
		Cart cart=cartDao.findByCustomer(custId);
		
		if(cart==null)
		{
			
			cart=new Cart();
			
			cart.setCustomer(customer);
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
			
			cartDao.save(cart);
			
		}
		return cart;
	}



	@Override
	public Cart deleteProductFromCart(Integer customerId, Integer productId) {
		
		Cart cart=cartDao.findByCustomer(customerId);
		
		if(cart==null)
			return null;
		else
		{
			
			CartProduct cartProduct=cartProductDao.findByProduct(productId,customerId);
			
			//cart.getCartProducts().remove(cartProduct);
			cartProductDao.delete(cartProduct);
			cart=cartDao.findByCustomer(customerId);
			
			return cart;
		}
		
	}



	@Override
	public Cart getCartProducts(Integer customerId) {
		
		Cart cart=cartDao.findByCustomer(customerId);
		return cart;
	}

	

}
