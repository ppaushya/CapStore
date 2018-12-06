package com.capstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Shipment {
	
	@Id
	@Column(name="shipmentId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shipmentId;
	
//	@Column(name="orderId")
	@OneToOne(targetEntity=Order.class)
	private int orderId;
	
	//@Column(name="addressId")
	@OneToOne(targetEntity=Address.class)
	private int addressId;
	
//	@Column(name="productId")
	@OneToOne(targetEntity=Product.class)
	private int productId;
	private String deliveryStatus;
	
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
	public String getString() {
		return deliveryStatus;
	}
	public void setString(String deliveryStatus) {
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
	public Shipment(int shipmentId, int orderId, int addressId, int productId, String deliveryStatus,
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