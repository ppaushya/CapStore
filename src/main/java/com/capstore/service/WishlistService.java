package com.capstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICustomerDao;
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
	
	@Autowired
	private ICustomerDao customerDao;

	@Override
	public boolean addToWishlist(int customerId, int productId) {
		
		Product product = productService.getProduct(productId);
		Customer customer = customerService.getCustomerByCustomerId(customerId);
		
		Wishlist myWishlist = wishlistDao.getWishlistByCustomerId(customerId);
		
		if(myWishlist.equals(null)) {
			myWishlist=new Wishlist();
			List<Product> products = new ArrayList<>();
			products.add(product);
			
			myWishlist.setCustomer(customer);
			myWishlist.setProducts(products);
			
			wishlistDao.save(myWishlist);
			
			return true;
		}else {
			
			myWishlist.getProducts().add(product);
			wishlistDao.save(myWishlist);
			return true;
			
			}
			
		
	}

	@Override
	public Wishlist deleteFromWishlist(int customerId, int productId) {
		
		Product product = productService.getProduct(productId);
		
		Wishlist myWishList = wishlistDao.getWishlistByCustomerId(customerId);
		
		
		
		List<Product> products = myWishList.getProducts();
		
		myWishList.getProducts().remove(product);
		
		wishlistDao.save(myWishList);
		
		return myWishList;
		
	}

	@Override
	public List<Product> wishListForSpecificCustomer(int customerId) {
		
		System.out.println("Printing 1");
		Wishlist myWishlist = wishlistDao.getWishlistByCustomerId(customerId);
		System.out.println("Printing 2");
		
		if(myWishlist.equals(null)) {
			return null;
		}
		
		return myWishlist.getProducts();
	}

	@Override
	public boolean moveFromWishlistToCart(int customerId, int productId) {
		
		deleteFromWishlist(customerId, productId);
		Customer customer=customerDao.getByCustomer(customerId);
		
		CartProduct cartProduct = new CartProduct();
		
		cartProduct.setProduct(productService.getProduct(productId));
		cartProduct.setCustomer(customerService.getCustomerByCustomerId(customerId));
		cartProduct.setQuantity(1);
		
		cartService.addProductToCart(cartProduct, customer.getEmailId());
		
		return true;
	}
}