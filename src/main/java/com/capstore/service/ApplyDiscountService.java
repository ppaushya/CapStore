package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICouponDao;
import com.capstore.dao.IPromoDao;
import com.capstore.model.Order;
import com.capstore.model.Product;
import com.capstore.model.Promos;


@Service("discountService")
public class ApplyDiscountService implements IApplyDiscountService{

	@Autowired
	private IPromoDao promoDao;

	@Override
	public int applyingDiscount(int promoId,int productId) {
		
	return 0;	
		
	//	return promoDao.applyingDiscount(promoId,productId);
		
		
		
		
		//return null;
		
		
		
		
	}

	

		
		
		
	

}
