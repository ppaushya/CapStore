package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Product;
import com.capstore.service.IProductService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	IProductService productService;
	

	@PostMapping("/product")
	public  ResponseEntity<Integer> bestseller(
			@RequestBody Product product ){
		      
		Product product1 = productService.bestSeller(product);
		if(product1.isEmpty())
				return new ResponseEntity("Nothing fetched",HttpStatus.NOT_FOUND) ;
		
		return new ResponseEntity<Integer>(product1,HttpStatus.OK);
		
		
	}
	

}
