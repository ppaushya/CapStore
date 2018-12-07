package com.capstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IProductDao;
import com.capstore.model.Product;
import com.capstore.model.SalesAnalysis;

@Service("productSenvice")
public class ProductService implements IProductService{

	@Autowired
	private IProductDao productDao;
	@Autowired
	private IMerchantService merchantService;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}
	
	/*@Override
	public List<SalesAnalysis> getSalesAnalysis() {
		double salesPercentage=0.00;
		List<Object[]> bestSellerDetails=productDao.getBestSellerId();
		List<Object[]> productSales=productDao.getProductSold();
		List<SalesAnalysis> salesAnalysis=new ArrayList<>();
		for(Object[] object:productSales)	{
			SalesAnalysis sales=new SalesAnalysis();
			sales.setProductCategory((String)object[0]);
			sales.setProductQuantity((Double)object[1]);
			sales.setProductSales((Double)object[2]);
			for(Object[] object1:bestSellerDetails)	{
				if(((String)object[0]).equals((String)object1[0]))
					sales.setMerchant(merchantService.getMerchantName((Integer)object1[1]));
			}
			salesPercentage=(sales.getProductSales()*100)/sales.getProductQuantity();
			sales.setSalesPercent(salesPercentage);
			
			salesAnalysis.add(sales);
		}
		return salesAnalysis;
	}
*/
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