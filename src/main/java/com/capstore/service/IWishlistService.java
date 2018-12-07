package com.capstore.service;

import java.util.List;

import com.capstore.model.Customer;
import com.capstore.model.Product;
import com.capstore.model.Wishlist;

public interface IWishlistService {

	public boolean addToWishlist(Customer customer, Product product);

	public Wishlist deleteFromWishlist(Customer customer, Product product);
	
	public List<Product> wishListForSpecificCustomer(Customer customer);
	
	public boolean moveFromWishlistToCart(Customer customer, Product product);
}