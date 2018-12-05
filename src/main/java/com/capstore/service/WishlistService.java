package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IWishlistDao;
import com.capstore.model.Wishlist;

@Service("wishlistService")
public class WishlistService implements IWishlistService{

	@Autowired
	private IWishlistDao wishlistDao;


	@Override
	public Wishlist addToWishlist(Wishlist wishlist) {

		long temp=wishlistDao.count();
		
			
		if(wishlistDao.findById(wishlist.getWishlistId())==null)
		{
			wishlistDao.save(wishlist);	
		}
		
		long temp2=wishlistDao.count();

		if(temp2==temp)
			return null;
		
		return wishlist;
	}


	@Override
	public List<Wishlist> viewWishlist() {
		
		return wishlistDao.findAll();
	}


	@Override
	public List<Wishlist> deleteFromWishlist(Wishlist wishlist) {

		wishlistDao.delete(wishlist);
		
		return wishlistDao.findAll();
	}

}
