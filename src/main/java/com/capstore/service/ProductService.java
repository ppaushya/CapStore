package com.capstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IProductDao;
import com.capstore.model.Product;

@Service("productSenvice")
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	/*@Override
	public int bestSeller() {
		
		Product product=productDao.findTop1ByOrderByproductsSoldDesc();
		int prod=product.getProductId();
		
		return prod;
		
	     
	}*/

	@Override
	public Product getProduct(int productId) {
		Optional<Product> optional = productDao.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public boolean updateProduct(Product product) {
		productDao.save(product);
		return true;
	}

	@Override
	public List<Product> getProductsWithoutPromotionalEmailSent() {
		return productDao.getProductsByIsPromotionMessageSent(false);
	}

}