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
import com.capstore.service.ICartService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CartController {
	
	@Autowired
	ICartService cartService;
	
	@DeleteMapping("/deleteCartProduct/{cartId}")
	public ResponseEntity<List<Cart>> deleteCartProduct(@PathVariable("cartId") Integer cartId )
	{
		
		List<Cart> cartProducts = cartService.deleteCartProduct(cartId);
		if (cartProducts == null)
			return new ResponseEntity("Sorry! Product is not available!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Cart>>(cartProducts, HttpStatus.OK);
	}
	
	@PostMapping("/addCartProduct")
	public ResponseEntity<List<Cart>> addCartProduct(@RequestBody Cart cartProduct,HttpSession session)
	{
		//int custId=(int) session.getAttribute("customerId");
		//System.out.println(custId);
	    // cartProduct.setCustomerId(custId);
		List<Cart> cartProducts=cartService.addCartProduct(cartProduct);
		if (cartProducts.isEmpty())
			return new ResponseEntity("Sorry!Product Cannot be added into cart!", HttpStatus.NOT_FOUND);
     	 return new ResponseEntity<List<Cart>>(cartProducts, HttpStatus.OK);
		
	}
	
	@GetMapping("/getCartProducts/{customerId}")
	public ResponseEntity<List<Cart>> getCartProducts(HttpSession session,@PathVariable("customerId") Integer custId)
	{
		//int custId=(int) session.getAttribute("customerId");
		List<Cart> cartProducts=cartService.getCartProducts(custId);
		if (cartProducts.isEmpty())
			return new ResponseEntity("Sorry! No products found in cart!", HttpStatus.NOT_FOUND);
     	 return new ResponseEntity<List<Cart>>(cartProducts, HttpStatus.OK);
	}
	
}
