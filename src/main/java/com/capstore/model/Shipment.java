package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Shipment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shipmentId;
	
	@OneToOne(targetEntity=Order.class)
	private int orderId;
	
	@OneToOne(targetEntity=Address.class)
	private int addressId;
	
	@OneToOne(targetEntity=Product.class)
	private int productId;
	private DeliveryStatus deliveryStatus;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date deliveryDate;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date dispatchDate;
	
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public DeliveryStatus getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Date getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(Date dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	@Override
	public String toString() {
		return "Shipment [shipmentId=" + shipmentId + ", orderId=" + orderId + ", addressId=" + addressId
				+ ", productId=" + productId + ", deliveryDate=" + deliveryDate + ", dispatchDate=" + dispatchDate
				+ "]";
	}
	public Shipment(int shipmentId, int orderId, int addressId, int productId, DeliveryStatus deliveryStatus,
			Date deliveryDate, Date dispatchDate) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.addressId = addressId;
		this.productId = productId;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.dispatchDate = dispatchDate;
	}
	public Shipment() {
		super();
	}
}