package com.capstore.service;

import java.util.List;

import com.capstore.model.Product;
import com.capstore.model.Wishlist;

public interface IWishlistService {

	public boolean addToWishlist(int customerId, int productId);

	public Wishlist deleteFromWishlist(int productId, int customerId);
	
	public List<Product> wishListForSpecificCustomer(int customerId);
}