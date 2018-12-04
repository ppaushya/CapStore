package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Order {
	
	@Id
	@GeneratedValue
	private int serialNo;
	private int orderId;
	
	@OneToOne(mappedBy="Customer")
	private int customerId;
	
	@OneToOne(mappedBy="Product")
	private int productId;
	
	@OneToOne(mappedBy="Shipment")
	private int shipmentId;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date orderDate;
	private int quantity;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Order [serialNo=" + serialNo + ", orderId=" + orderId + ", customerId=" + customerId + ", productId="
				+ productId + ", shipmentId=" + shipmentId + ", orderDate=" + orderDate + ", quantity=" + quantity
				+ "]";
	}
	public Order(int serialNo, int orderId, int customerId, int productId, int shipmentId, Date orderDate,
			int quantity) {
		super();
		this.serialNo = serialNo;
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.shipmentId = shipmentId;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}
	public Order() {
		super();
	}
}