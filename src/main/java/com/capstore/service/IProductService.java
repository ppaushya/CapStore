package com.capstore.service;

import java.util.List;

import com.capstore.model.Product;

public interface IProductService {

	public List<Product> getAllProducts();
	//public int bestSeller();
	
	public Product getProduct(int productId);

	public boolean updateProduct(Product product);
	
	public List<Product> getProductsWithoutPromotionalEmailSent();
}