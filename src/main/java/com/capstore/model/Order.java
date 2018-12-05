package com.capstore.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="productOrder")
public class Order {
	
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;
	
//	@Column(name="customerId")
	@OneToOne(targetEntity=Customer.class)
	private int customerId;
	
//	@Column(name="productId")
	@OneToMany(targetEntity=Product.class)
	private List<Product> orderedProducts;
	
//	@Column(name="shipmentId")
	@OneToOne(targetEntity=Shipment.class)
	private int shipmentId;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date orderDate;
	private int quantity;
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
	public List<Product> getOrderedProducts() {
		return orderedProducts;
	}
	public void setOrderedProducts(List<Product> orderedProducts) {
		this.orderedProducts = orderedProducts;
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
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", orderedProducts=" + orderedProducts
				+ ", shipmentId=" + shipmentId + ", orderDate=" + orderDate + ", quantity=" + quantity + "]";
	}
	public Order(int orderId, int customerId, List<Product> orderedProducts, int shipmentId, Date orderDate,
			int quantity) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderedProducts = orderedProducts;
		this.shipmentId = shipmentId;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}
}