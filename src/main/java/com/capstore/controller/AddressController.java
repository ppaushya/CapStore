package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Address;
import com.capstore.service.AddressService;

import antlr.collections.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class AddressController {
	// To get All addresses from DB
	
	@Autowired
	 AddressService addressService;
	
	
	@GetMapping(value = "/address/all")
	public ResponseEntity<java.util.List<Address>> getAllAddress() {
		System.out.println("");
		java.util.List<Address> list = addressService.getAllAddresses();
		System.out.println("Controller"+list);
		if (list==null) {
			new ResponseEntity("No account found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<java.util.List<Address>>(list, HttpStatus.OK);
	}

	
	@PostMapping(value = "/address")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		System.out.println(address+"i am here");
		Address address1 = addressService.createAddress(address);
		System.out.println("Controller"+address);
		if (address==null) {
			new ResponseEntity("No account found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Address>(address1, HttpStatus.OK);
	}
}