package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstore.model.Order;
import com.capstore.model.Shipment;
import com.capstore.service.IShipmentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ShipmentController {

	@Autowired
	private IShipmentService shipmentService;

	@PostMapping(value = "/shipment")
	public ResponseEntity<Shipment> insertshipment(@RequestBody Shipment shipment) {
		System.out.println("add customer");
		System.out.println(shipment);

		Shipment shipment1 = shipmentService.insertshipment(shipment);

		if (shipment == null)
			return new ResponseEntity("Insertion Failed", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Shipment>(shipment1, HttpStatus.OK);
	}

	@GetMapping(value = "/shipment/{shipmentId}")
	public ResponseEntity<Shipment> getShipment(@PathVariable("shipmentId") Integer shipmentId) {
		Shipment shipment = shipmentService.getShipment(shipmentId);
		if (shipment == null)
			return new ResponseEntity("Sorry! Shipment is unavailable!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Shipment>(shipment, HttpStatus.OK);
	}
	
	@GetMapping(value = "/shipment/all")
	public ResponseEntity<List<Shipment>> getAllShipments() {
		List<Shipment> shipments = shipmentService.getAllShipments();
		if (shipments.isEmpty())
			return new ResponseEntity("Sorry! No Shipments unavailable!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Shipment>>(shipments, HttpStatus.OK);
	}
	
	@GetMapping(value = "/shipment/undelivered")
	public ResponseEntity<List<Shipment>> getAllUndeliveredShipments() {
		List<Shipment> shipments = shipmentService.getAllUndeliveredShipments();
		if (shipments.isEmpty())
			return new ResponseEntity("Sorry! No Undelivered Shipments unavailable!", HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Shipment>>(shipments, HttpStatus.OK);
	}

	@PostMapping("/getShipmentDeliveryStatus/{shipmentId}")
	public ResponseEntity<String> getShipmentDeliveryStatus(@PathVariable("shipmentId") Integer shipmentId) {
		String shipmentDeliveryStatus = shipmentService.getShipmentDeliveryStatus(shipmentId);
		if (shipmentDeliveryStatus != null) {
			return new ResponseEntity<String>(shipmentDeliveryStatus, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Sorry, shipment is not available!", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updateShipmentDeliveryStatus/{shipmentId}/{status}")
	public ResponseEntity<String> deliverOrderAndUpdateInventory(@PathVariable("shipmentId") Integer shipmentId,
			@PathVariable("status") String status) {
		// boolean shipment2 = shipmentService.updateShipmentDeliveryStatus(shipmentId,
		// status);
		if (shipmentService.updateShipmentDeliveryStatus(shipmentId, status)) {
			return new ResponseEntity("status of shipment updated", HttpStatus.OK);
		} else {
			return new ResponseEntity("status of shipment can't be updated", HttpStatus.NOT_FOUND);
		}
	}
}
