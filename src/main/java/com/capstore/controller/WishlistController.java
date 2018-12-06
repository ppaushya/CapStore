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

import com.capstore.model.Wishlist;
import com.capstore.service.IWishlistService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class WishlistController {

	@Autowired
	private IWishlistService wishlistService;
	
	@PostMapping("/addingtowishlist")
	public ResponseEntity<Wishlist> addToWishlist(@RequestBody Wishlist wishlist){
		Wishlist mywishlist=wishlistService.addToWishlist(wishlist);
		
		return new ResponseEntity<Wishlist>(mywishlist,HttpStatus.OK);
	}
	
	@GetMapping("/viewWishlist")
	public ResponseEntity<List<Wishlist>> viewWishlist(){
	
		List<Wishlist> mywishlist=wishlistService.viewWishlist();
		
		return new ResponseEntity<List<Wishlist>>(mywishlist,HttpStatus.OK);
	}
	
	@PostMapping("/deleteFromWishlist")
	public ResponseEntity<List<Wishlist>> deleteFromWishlist(@RequestBody Wishlist wishlist){
		
		
		List<Wishlist> mywishlist=wishlistService.deleteFromWishlist(wishlist);
		
		
		return new ResponseEntity<List<Wishlist>>(mywishlist,HttpStatus.OK);
	}
	
	
	public ResponseEntity<Wishlist> addTocart(@RequestBody Wishlist wishlist){
		
		return null;
	}
	
}
