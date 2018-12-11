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

import com.capstore.model.Invoice;
import com.capstore.model.Order;
import com.capstore.model.Shipment;
import com.capstore.service.IInvoiceService;
import com.capstore.service.IShipmentService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class InvoiceController {
	
	
	@Autowired
	private IInvoiceService invoiceService;
	
	/*@PostMapping(value = "/invoice")
	public ResponseEntity<Invoice> insertShipment(@RequestBody Invoice invoice) {
		System.out.println("add customer");
		System.out.println(invoice);
		
		Invoice invoice1=invoiceService.insertInvoice(invoice);
		
		if(invoice==null)
			return new ResponseEntity("Insertion Failed",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Invoice>(invoice1,HttpStatus.OK);
	}*/
	
	@GetMapping(value = "/generateInvoice")
	public ResponseEntity<Invoice> getInvoice(@RequestBody Order order){
		
		Invoice requiredInvoice = invoiceService.getInvoiceFromOrderId(order.getOrderId());
		
		return new ResponseEntity<Invoice>(requiredInvoice, HttpStatus.OK);
		
	}
}