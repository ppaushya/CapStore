package com.capstore.service;

import java.util.List;
import com.capstore.model.Customer;
import com.capstore.model.Inventory;
import com.capstore.model.Product;

public interface IProductService {

	public List<Product> getAllProducts();
	//public List<SalesAnalysis> getSalesAnalysis();
	
	public Product getProduct(int productId);

	public boolean updateProduct(Product product);
	
	public List<Product> getProductsWithoutPromotionalEmailSent();
	
	public List<Product> getSimilarProducts(int productId);
	
	public double getDiscountedPrice(Product product);

	public void addNewProduct(Inventory inventory);

	public void editProduct(Inventory inventory);
	
	public List<Object[]> getBestSellerId();
}