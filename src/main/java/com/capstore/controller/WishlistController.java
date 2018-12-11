package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/addingtowishlist/{customerId}/{productId}")
	public ResponseEntity<Boolean> addToWishlist(@PathVariable("productId") Integer productId,
			@PathVariable("customerId") Integer customerId ){
		Boolean success = wishlistService.addToWishlist(customerId, productId);
		
		return new ResponseEntity<Boolean>(success,HttpStatus.OK);
	}
	
	@GetMapping("/viewWishlist/{customerId}")
	public ResponseEntity<List<Product>> wishListForSpecificCustomer(@PathVariable("customerId") Integer customerId){
	
		List<Product> products=wishlistService.wishListForSpecificCustomer(customerId);
		
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteFromWishlist/{customerId}/{productId}")
	public ResponseEntity<Wishlist> deleteFromWishlist(@PathVariable("productId") Integer productId,
			@PathVariable("customerId") Integer customerId ){
		
		Wishlist wishlist=wishlistService.deleteFromWishlist(customerId, productId);
		
		return new ResponseEntity<Wishlist>(wishlist,HttpStatus.OK);
	}
	
	@DeleteMapping("/moveFromWishlistToCart/{customerId}/{productId}")
	public ResponseEntity<Boolean> moveFromWishlistToCart(@PathVariable("productId") Integer productId,
			@PathVariable("customerId") Integer customerId ){
		
		Boolean success = wishlistService.moveFromWishlistToCart(customerId, productId);
		
		return new ResponseEntity<Boolean>(success, HttpStatus.OK);
	}
}