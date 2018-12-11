package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IPromoDao;
import com.capstore.model.Promos;

<<<<<<< HEAD
@Service("promoService")
=======
@Service("/promoService")
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
public class PromoService implements IPromoService{

	@Autowired
<<<<<<< HEAD
	IPromoDao promoDao;
	
	@Override
	public int getDiscount(int promoId) {
		
		Promos p= (Promos) promoDao.getById(promoId);
		return p.getDiscount();
=======
	 IPromoDao promoDao;
	
	@Override
	public void addPromo(Promos promo) {
		promoDao.save(promo);
	
		
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
	}

}
