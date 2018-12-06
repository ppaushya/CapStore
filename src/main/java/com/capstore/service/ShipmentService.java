package com.capstore.service;

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

}
