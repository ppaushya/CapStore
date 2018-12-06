
package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Coupons;
import com.capstore.model.Feedback;
import com.capstore.service.ICouponService;
import com.capstore.service.IFeedbackService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class CouponsController {

	@Autowired
	ICouponService couponService;
	
	@PostMapping("/verifyingcoupon")
	public ResponseEntity<Boolean> applyingCoupon(
			@RequestBody Coupons coupons){
		
		couponService.applyingCoupon(coupons);
		
		return new ResponseEntity<>(true,HttpStatus.OK);

	}
	
}


