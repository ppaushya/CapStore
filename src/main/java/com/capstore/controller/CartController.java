package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Cart;
import com.capstore.model.CartProduct;
import com.capstore.service.ICartService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CartController {

	@Autowired
	ICartService cartService;
	
	@DeleteMapping("/deleteProductFromCart/{customerId}/{productId}")
	public ResponseEntity<Cart> deleteCartProduct(@PathVariable("customerId") Integer customerId,
													@PathVariable("productId") Integer productId)
	{
		Cart cart=cartService.deleteProductFromCart(customerId,productId);
		
		if(cart==null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	

	@PostMapping("/addProductToCart/{custId}")
	public ResponseEntity<Cart> addProductToCart(@RequestBody CartProduct cartProduct,
													@PathVariable("custId") Integer custId, HttpSession session) 
	{
		Cart cart = cartService.addProductToCart(cartProduct, custId);
	
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@GetMapping("/getCartProducts/{customerId}")
	public ResponseEntity<Cart> getCartProducts(HttpSession sessison, @PathVariable("customerId") Integer customerId) {
		
		Cart cart=cartService.getCartProducts(customerId);
		
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);

	}
	
	@PostMapping("/updateCartProductQuantity/{customerId}")
	public ResponseEntity<Cart> updateCartProductQuantity(@RequestBody CartProduct cartProduct,
														@PathVariable("customerId") Integer customerId, HttpSession session){
		
		Cart cart=cartService.updateCartProductQuantity(cartProduct,customerId);
		
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		
	}
}
