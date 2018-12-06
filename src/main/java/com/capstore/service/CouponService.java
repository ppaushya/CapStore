package com.capstore.service;

import org.springframework.stereotype.Service;

import com.capstore.dao.ICouponDao;
import com.capstore.model.Coupons;

@Service("couponService")
public class CouponService implements ICouponService{

	
	private ICouponDao couponsDao;
	
	@Override
	public Boolean applyingCoupon(Coupons coupons) {
		// TODO Auto-generated method stub
		if(couponsDao.findById(coupons.getCouponId())!=null)
		{
			return true;
		}
		return false;
		
	}

}
