package com.capstore.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IWishlistDao;
import com.capstore.model.CartProduct;
import com.capstore.model.Customer;
import com.capstore.model.Product;
import com.capstore.model.Wishlist;

@Service("wishlistService")
public class WishlistService implements IWishlistService{

	@Autowired
	private IWishlistDao wishlistDao;
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ICustomerService customerService;

	@Override
	public boolean addToWishlist(int customerId, int productId) {
		
		Product product = productService.getProduct(productId);
		Customer customer = customerService.getCustomerByCustomerId(customerId);
		
		Wishlist myWishlist = wishlistDao.getWishlistByCustomerId(customerId);
		
		if(myWishlist == null) {
			
			List<Product> products = new ArrayList<>();
			products.add(product);
			myWishlist = new Wishlist();
			
			myWishlist.setCustomer(customer);
			myWishlist.setProducts(products);
			
			wishlistDao.save(myWishlist);
			System.out.println(myWishlist);
			
			return true;
		}else {
			
			List<Product> products = myWishlist.getProducts();
			Iterator<Product> productIterator = products.iterator();
			while(productIterator.hasNext()) {
				Product myProduct = productIterator.next();
				if(myProduct.equals(product)) {
					return true;
				}
			}
			products.add(product);
			myWishlist.setProducts(products);
			wishlistDao.save(myWishlist);
		}
		
		return false;
	}

	@Override
	public Wishlist deleteFromWishlist(int customerId, int productId) {
		
		Product product = productService.getProduct(productId);
		
		Wishlist myWishList = wishlistDao.getWishlistByCustomerId(customerId);
		
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

	@Override
	public List<Product> wishListForSpecificCustomer(int customerId) {
		
		Wishlist myWishlist = wishlistDao.getWishlistByCustomerId(customerId);
		
		if(myWishlist == null) {
			return null;
		}
		
		return myWishlist.getProducts();
	}

	@Override
	public boolean moveFromWishlistToCart(int customerId, int productId) {
		
		deleteFromWishlist(customerId, productId);
		
		CartProduct cartProduct = new CartProduct();
		
		cartProduct.setProduct(productService.getProduct(productId));
		cartProduct.setCustomer(customerService.getCustomerByCustomerId(customerId));
		cartProduct.setQuantity(1);
		
		cartService.addProductToCart(cartProduct, customerId);
		
		return true;
	}
}