package com.capstore.service;

import java.util.List;

import com.capstore.model.Order;
import com.capstore.model.Promos;

public interface IApplyDiscountService {

	int applyingDiscount(int promoId,int productId);

	

}
