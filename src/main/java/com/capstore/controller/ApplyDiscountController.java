package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capstore.model.Promos;
import com.capstore.service.IApplyDiscountService;
import com.capstore.service.IPromoService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ApplyDiscountController {
	
	
	@Autowired
	IApplyDiscountService applydiscountService;
	
	@Autowired
	IPromoService promoService;
	
	
	@PostMapping("/verifyingapplydiscount/promoId/productId")
	public ResponseEntity<Boolean> applyingDiscount(
			@RequestBody int promoId,
			@RequestBody int productId){
		
		
		int discounts=promoService.getDiscount(promoId);
		
		applydiscountService.applyingDiscount(promoId,productId);
		
		return new ResponseEntity<>(true,HttpStatus.OK);

		
	}

}
