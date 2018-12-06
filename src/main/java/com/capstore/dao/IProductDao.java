package com.capstore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Product;

@Repository("productDao")
@Transactional
public interface IProductDao extends JpaRepository<Product,Integer> {

	//public Product findTop1ByOrderByproductsSoldDesc();
	public List<Product> getProductsByIsPromotionMessageSent(boolean isSent);

}
