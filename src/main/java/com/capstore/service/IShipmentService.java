package com.capstore.service;

import com.capstore.model.Shipment;

public interface IShipmentService {

	public Shipment insertshipment(Shipment shipment);
	
	public Shipment getShipment(int shipmentId);
		
	public String getShipmentDeliveryStatus(int shipmentId);
	public boolean updateShipmentDeliveryStatus(int shipmentId, String status);
	
}
