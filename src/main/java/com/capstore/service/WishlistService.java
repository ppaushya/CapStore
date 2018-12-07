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
	private ICustomerService customerService;
	
	@Autowired
	private IProductService productService;


	@Override
	public boolean addToWishlist(int customerId, int productId) {
		
		boolean isWishListPresent=false;
		Product productToAdd = productService.getProduct(productId);
		Customer customer = customerService.getCustomerByCustomerId(customerId);

		List<Wishlist> wishLists =  wishlistDao.findAll();
		Iterator<Wishlist> WishListIterator = wishLists.iterator();
		
		while (WishListIterator.hasNext()) {
			Wishlist myWishList = WishListIterator.next();
			if(myWishList.getCustomer().getCustomerId() == customerId) {
				List<Product> products = myWishList.getProducts();
				Iterator<Product> productIterator = products.iterator();
				
				while(productIterator.hasNext()) {
					Product myProduct = productIterator.next();
					if(myProduct.getProductId() == productId) {
						isWishListPresent = true;
						return true;
					}
				}
				products.add(productToAdd);
				isWishListPresent = true;
				return true;
			}
		}
		if(!isWishListPresent) {
			Wishlist requiredWishlist = new Wishlist();
			
			List<Product> products = new ArrayList<>();
			products.add(productToAdd);
			
			requiredWishlist.setCustomer(customer);
			requiredWishlist.setProducts(products);
			
			wishlistDao.save(requiredWishlist);
			
		}
		return true;
	}

	@Override
	public Wishlist deleteFromWishlist(int productId, int customerId) {

		List<Wishlist> wishLists =  wishlistDao.findAll();
		Iterator<Wishlist> WishListIterator = wishLists.iterator();
		
		while (WishListIterator.hasNext()) {
			Wishlist myWishList = WishListIterator.next();
			if(myWishList.getCustomer().getCustomerId() == customerId) {
				List<Product> products = myWishList.getProducts();
				Iterator<Product> productIterator = products.iterator();
				
				while(productIterator.hasNext()) {
					Product myProduct = productIterator.next();
					if(myProduct.getProductId() == productId) {
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
	public List<Product> wishListForSpecificCustomer(int customerId) {
		
		List<Wishlist> wishLists =  wishlistDao.findAll();
		
		for(Wishlist myWishList: wishLists) {
			if(myWishList.getCustomer().getCustomerId() == customerId) {
				
				return myWishList.getProducts(); 
			}
		}
		return null;
	}
}