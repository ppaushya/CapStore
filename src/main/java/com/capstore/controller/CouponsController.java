
package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Coupons;
import com.capstore.service.ICouponService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CouponsController {

	@Autowired
	ICouponService couponService;
	
	@PostMapping("/verifyingcoupon/{couponCode}")
	public ResponseEntity<Coupons> applyingCoupon(@PathVariable("couponCode") String couponCode){
		
		Coupons couponResponse = couponService.checkIfCouponCodeIsValid(couponCode);
		
		return new ResponseEntity<Coupons>(couponResponse,HttpStatus.OK);

	}
}