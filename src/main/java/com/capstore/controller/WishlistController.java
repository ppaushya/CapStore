package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Customer;
import com.capstore.model.Product;
import com.capstore.model.Wishlist;
import com.capstore.service.IWishlistService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class WishlistController {

	@Autowired
	private IWishlistService wishlistService;
	
	@PostMapping("/addingtowishlist")
	public ResponseEntity<Boolean> addToWishlist(@RequestBody Customer customer, 
			@RequestBody Product product){
		Boolean success = wishlistService.addToWishlist(customer.getCustomerId() , product.getProductId());
		
		return new ResponseEntity<Boolean>(success,HttpStatus.OK);
	}
	
	@GetMapping("/viewWishlist")
	public ResponseEntity<List<Product>> wishListForSpecificCustomer(@RequestBody Customer customer){
	
		List<Product> products=wishlistService.wishListForSpecificCustomer(customer.getCustomerId());
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PostMapping("/deleteFromWishlist")
	public ResponseEntity<Wishlist> deleteFromWishlist(@RequestBody Customer customer, 
			@RequestBody Product product){
		
		Wishlist wishlist=wishlistService.deleteFromWishlist(customer.getCustomerId(), product.getProductId());
		
		return new ResponseEntity<Wishlist>(wishlist,HttpStatus.OK);
	}
	
	public ResponseEntity<Wishlist> addTocart(@RequestBody Wishlist wishlist){
		
		return null;
	}	
}