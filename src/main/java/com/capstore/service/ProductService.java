package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IProductDao;
import com.capstore.model.Product;

@Service("productService")
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	@Override
	public int bestSeller() {
		
		Product product=productDao.findTop1ByOrderByproductsSoldDesc();
		int prod=product.getProductId();
		
		return prod;
		
	     
	}

}
