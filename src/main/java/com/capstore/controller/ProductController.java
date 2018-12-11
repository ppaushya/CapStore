package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Product;
import com.capstore.model.SalesAnalysis;
import com.capstore.service.IProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=productService.getAllProducts();
		if(products.isEmpty())
			return new ResponseEntity("Sorry! No Products Available!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	/*@GetMapping("/products/salesAnalysis")
	public ResponseEntity<List<SalesAnalysis>> getSalesAnalysis(){
		//List<SalesAnalysis> salesAnalysis=productService.getSalesAnalysis();
		if(salesAnalysis.isEmpty())
			return new ResponseEntity("Sorry! No Sales is done!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<List<SalesAnalysis>>(salesAnalysis, HttpStatus.OK);
	}*/

	@GetMapping("/similarProducts/{productId}")
	public ResponseEntity<List<Product>> getSimilarProducts(@PathVariable("productId") Integer productId){
		
		List<Product> products = productService.getSimilarProducts(productId);
		
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
	
	@PostMapping("/verifyCoupon/{productId}")
	public ResponseEntity<Double> applyingDiscount( @PathVariable("productId") Integer productId){
		
		Product product = productService.getProduct(productId);
		double discountedPrice = productService.getDiscountedPrice(product);
		
		return new ResponseEntity<Double>(discountedPrice,HttpStatus.OK);
	}
}