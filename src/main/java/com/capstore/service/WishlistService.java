package com.capstore.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IWishlistDao;
import com.capstore.model.Customer;
import com.capstore.model.Product;
import com.capstore.model.Wishlist;

@Service("wishlistService")
public class WishlistService implements IWishlistService{

	@Autowired
	private IWishlistDao wishlistDao;
	
	@Autowired
	private ICartService cartService;

	@Override
	public boolean addToWishlist(Customer customer, Product product) {
		
		boolean isWishListPresent=false;
		
		List<Wishlist> wishLists =  wishlistDao.findAll();
		Iterator<Wishlist> WishListIterator = wishLists.iterator();
		
		while (WishListIterator.hasNext()) {
			Wishlist myWishList = WishListIterator.next();
			if(myWishList.getCustomer().equals(customer)) {
				List<Product> products = myWishList.getProducts();
				Iterator<Product> productIterator = products.iterator();
				isWishListPresent = true;
				while(productIterator.hasNext()) {
					Product myProduct = productIterator.next();
					if(myProduct.equals(product)) {
						return true;
					}
				}
				products.add(product);
				return true;
			}
		}
		if(!isWishListPresent) {
			Wishlist requiredWishlist = new Wishlist();
			
			List<Product> products = new ArrayList<>();
			products.add(product);
			
			requiredWishlist.setCustomer(customer);
			requiredWishlist.setProducts(products);
			
			wishlistDao.save(requiredWishlist);
			
		}
		return true;
	}

	@Override
	public Wishlist deleteFromWishlist(Customer customer, Product product) {

		List<Wishlist> wishLists =  wishlistDao.findAll();
		Iterator<Wishlist> WishListIterator = wishLists.iterator();
		
		while (WishListIterator.hasNext()) {
			Wishlist myWishList = WishListIterator.next();
			if(myWishList.getCustomer().equals(customer)) {
				List<Product> products = myWishList.getProducts();
				Iterator<Product> productIterator = products.iterator();
				
				while(productIterator.hasNext()) {
					Product myProduct = productIterator.next();
					if(myProduct.equals(product)) {
						products.remove(myProduct);
					}
				}
				if(products.size() == 0) {
					wishlistDao.delete(myWishList);
					return null;
				}
				return myWishList;
			}
		}
		return null;
	}

	@Override
	public List<Product> wishListForSpecificCustomer(Customer customer) {
		
		List<Wishlist> wishLists =  wishlistDao.findAll();
		
		for(Wishlist myWishList: wishLists) {
			if(myWishList.getCustomer().equals(customer)) {
				
				return myWishList.getProducts(); 
			}
		}
		return null;
	}

	@Override
	public boolean moveFromWishlistToCart(Customer customer, Product product) {
		
		Wishlist myWishlist = deleteFromWishlist(customer, product);
		
		
		return false;
	}
}