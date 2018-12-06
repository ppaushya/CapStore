package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@DeleteMapping("/deleteCartProduct/{productId}")
	public ResponseEntity<List<Cart>> deleteCartProduct(@PathVariable("productId") Integer productId )
	{
		
		List<Cart> cartProducts = cartService.deleteCartProduct(productId);
		if (cartProducts == null)
			return new ResponseEntity("Sorry! Pilot Id not available!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Cart>>(cartProducts, HttpStatus.OK);
	}
	
	@PutMapping("/addCartProduct")
	public ResponseEntity<List<Cart>> addCartProduct(@RequestBody Cart cartProduct)
	{
		return null;
		//List<Cart> cartProducts = cartService.;
//		if (cartProducts == null)
//			return new ResponseEntity("Sorry! Pilot Id not available!", HttpStatus.NOT_FOUND);
//		return new ResponseEntity<List<Cart>>(cartProducts, HttpStatus.OK);
	}	
	
	
	@DeleteMapping("/deletecart")
	public ResponseEntity<String> deleteCartAfterOrder(HttpSession session){
		int customerId= Integer.parseInt(session.getAttribute("customerId").toString());
		cartService.deleteCartAfterOrder(customerId);
		return new ResponseEntity<String>("Cart Deleted Successfully!",HttpStatus.OK);
		
		
	}
	
}
