package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Product;
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
	
	/*@GetMapping("/product")
	public  ResponseEntity<Integer> bestSeller(){
		      
		int product1 = productService.bestSeller();
		if(product1==0)
				return new ResponseEntity("Nothing fetched",HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Integer>(product1,HttpStatus.OK);
		
		
	}*/

}
