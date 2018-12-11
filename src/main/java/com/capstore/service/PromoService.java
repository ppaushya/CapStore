package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IPromoDao;
import com.capstore.model.Promos;

@Service("promoService")
public class PromoService implements IPromoService{

	@Autowired
	IPromoDao promoDao;
	
	@Override
	public int getDiscount(int promoId) {
		
		Promos p= (Promos) promoDao.getById(promoId);
		return p.getDiscount();
	}

}
