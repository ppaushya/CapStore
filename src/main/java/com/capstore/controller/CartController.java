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
	
	@DeleteMapping("/deleteProductFromCart/{customerEmailId}/{productId}")
	public ResponseEntity<Cart> deleteCartProduct(@PathVariable("customerEmailId") String customerEmailId,
													@PathVariable("productId") Integer productId)
	{
		Cart cart=cartService.deleteProductFromCart(customerEmailId,productId);
		
		if(cart==null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	

	@PostMapping("/addProductToCart/{customerEmailId}")
	public ResponseEntity<Cart> addProductToCart(@RequestBody CartProduct cartProduct,
													@PathVariable("customerEmailId") String customerEmailId, HttpSession session) 
	{
		Cart cart = cartService.addProductToCart(cartProduct, customerEmailId);
	
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}

	@GetMapping("/getCartProducts/{customerEmailId}")
	public ResponseEntity<Cart> getCartProducts(HttpSession sessison, @PathVariable("customerEmailId") String customerEmailId) {
		
		Cart cart=cartService.getCartProducts(customerEmailId);
		
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);

	}
	
	@PostMapping("/updateCartProductQuantity/{customerEmailId}")
	public ResponseEntity<Cart> updateCartProductQuantity(@RequestBody CartProduct cartProduct,
														@PathVariable("customerEmailId") String customerEmailId, HttpSession session){
		
		Cart cart=cartService.updateCartProductQuantity(cartProduct,customerEmailId);
		
		if (cart == null)
			return new ResponseEntity("Sorry! Cart is not available", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		
	}
	
	@GetMapping("/cartcount")
	public ResponseEntity<Integer> getCount(){
		int count=cartService.getCount();
				if(count==0)
					return new ResponseEntity("Sorry",HttpStatus.NOT_FOUND);
				return new ResponseEntity<Integer>(count,HttpStatus.OK);
				
		
	}
}
