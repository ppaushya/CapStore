package com.capstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IShipmentDao;
import com.capstore.model.Shipment;

@Service("shipmentService")
public class ShipmentService implements IShipmentService{

	@Autowired
	IShipmentDao shipmentdao;
	
	@Override
	public Shipment insertshipment(Shipment shipment) {
		
		return shipmentdao.save(shipment);
	}

	@Override
	public Shipment getShipment(int shipmentId) {
		Optional<Shipment> optional = shipmentdao.findById(shipmentId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public String getShipmentDeliveryStatus(int shipmentId) {
		Shipment shipment = getShipment(shipmentId);
		if(shipment!=null) {
			return shipment.getDeliveryStatus();
		}
		return null;
	}

	@Override
	public boolean updateShipmentDeliveryStatus(int shipmentId, String status) {
		Shipment shipment = getShipment(shipmentId);
		if(shipment!=null) {
			shipment.setDeliveryStatus(status);
			return true;
		}
		return false;
	}

}
