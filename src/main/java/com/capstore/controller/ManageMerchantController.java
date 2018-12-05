package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Merchant;
import com.capstore.service.IMerchantService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ManageMerchantController {

	@Autowired
	IMerchantService merchantService;
	
	@PostMapping("/merchants")
	public ResponseEntity<Boolean> addMerchant(
			@RequestBody Merchant merchant){
		merchantService.addMerchant(merchant);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/merchants/{merchantId}")
	public ResponseEntity<Boolean> deleteMerchant(@PathVariable Integer merchantId){
		
		merchantService.deleteMerchant(merchantId);
		return new ResponseEntity<>(true,HttpStatus.OK);
	
	}
	
}
