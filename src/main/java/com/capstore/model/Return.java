package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Return {
	
	@Id
	@GeneratedValue
	private int returnId;
	
	@OneToOne(mappedBy="Order")
	private int orderId;
	
	@OneToOne(mappedBy="Product")
	private int productId;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date pickupDate;
	private ReturnStatus returnStatus;
	
	public int getReturnId() {
		return returnId;
	}
	public void setReturnId(int returnId) {
		this.returnId = returnId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public Date getPickupDate() {
		return pickupDate;
	}
	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}
	public ReturnStatus getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(ReturnStatus returnStatus) {
		this.returnStatus = returnStatus;
	}
	@Override
	public String toString() {
		return "Return [returnId=" + returnId + ", orderId=" + orderId + ", productId=" + productId + ", pickupDate="
				+ pickupDate + ", returnStatus=" + returnStatus + "]";
	}
	public Return(int returnId, int orderId, int productId, Date pickupDate, ReturnStatus returnStatus) {
		super();
		this.returnId = returnId;
		this.orderId = orderId;
		this.productId = productId;
		this.pickupDate = pickupDate;
		this.returnStatus = returnStatus;
	}
	public Return() {
		super();
	}
}