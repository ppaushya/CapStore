package com.capstore.service;

import java.util.List;

import com.capstore.model.Wishlist;

public interface IWishlistService {

	Wishlist addToWishlist(Wishlist wishlist);

	List<Wishlist> viewWishlist();

	List<Wishlist> deleteFromWishlist(Wishlist wishlist);

}
