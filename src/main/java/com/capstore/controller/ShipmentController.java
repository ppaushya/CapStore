package com.capstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Shipment;
import com.capstore.service.IShipmentService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ShipmentController {
	
	@Autowired
	private IShipmentService shipmentService;
	
	@PostMapping(value = "/shipment")
	public ResponseEntity<Shipment> insertshipment(@RequestBody Shipment shipment) {
		System.out.println("add customer");
		System.out.println(shipment);
		
		Shipment shipment1=shipmentService.insertshipment(shipment);
		
		if(shipment==null)
			return new ResponseEntity("Insertion Failed",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Shipment>(shipment1,HttpStatus.OK);
	}
	

}
