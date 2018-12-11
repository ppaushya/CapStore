package com.capstore.service;

import com.capstore.model.Promos;

public interface IPromoService {

	int getDiscount(int promoId);
	public void addPromo(Promos promo);

}