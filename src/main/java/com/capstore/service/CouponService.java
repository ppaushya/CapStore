package com.capstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.ICouponDao;
import com.capstore.model.Coupons;

@Service("couponService")
public class CouponService implements ICouponService{

	@Autowired
	private ICouponDao couponsDao;
	
	@Override
	public Boolean applyingCoupon(Coupons coupons) {
		Optional<Coupons> coupon=couponsDao.findById(coupons.getCouponId());
		if(coupon.isPresent()) {
			return true;
		}
		return false;
		
	}

}
