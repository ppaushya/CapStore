package com.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capstore.model.Product;

@Repository("productDao")
@Transactional
public interface IProductDao extends JpaRepository<Product,Integer> {

	//public Product findTop1ByOrderByproductsSoldDesc();
	public List<Product> getProductsByIsPromotionMessageSent(boolean isSent);

	@Query("SELECT productCategory, SUM(quantity), SUM(productsSold) FROM"
			+ " Product group by productCategory")
	public List<Object[]> getProductSold();
	
	
	@Query("SELECT productCategory, merchantId FROM Product WHERE productsSold in(SELECT MAX(productsSold) from Product GROUP BY productCategory)")
	public List<Object[]> getBestSellerId();
}
