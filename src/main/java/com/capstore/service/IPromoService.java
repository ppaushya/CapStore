package com.capstore.service;

import java.util.List;

import com.capstore.model.Promos;

public interface IPromoService {

	public void addPromo(Promos promo);

	public List<Promos> getAllPromos();

	public Promos getPromo(String promoCode);


}
