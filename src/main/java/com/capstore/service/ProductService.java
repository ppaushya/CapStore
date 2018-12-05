package com.capstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capstore.model.Product;

@Service("productService")
public class ProductService implements IProductService{

	@Override
	public List<Product> bestSeller(Product product) {
		
		return ;
	}

}
