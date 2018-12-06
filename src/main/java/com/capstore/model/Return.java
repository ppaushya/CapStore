package com.capstore.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="productReturn")
public class Return {
	
	@Id
	@Column(name="returnId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int returnId;
	
//	@Column(name="orderId")
	@OneToOne(targetEntity=Order.class)
	private int orderId;
	
//	@Column(name="productId")
	@OneToOne(targetEntity=Product.class)
	private int productId;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date pickupDate;
	
	private String returnStatus;

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

	public String getReturnStatus() {
		return returnStatus;
	}

	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}

	@Override
	public String toString() {
		return "Return [returnId=" + returnId + ", orderId=" + orderId + ", productId=" + productId + ", pickupDate="
				+ pickupDate + ", returnStatus=" + returnStatus + "]";
	}

	public Return(int returnId, int orderId, int productId, Date pickupDate, String returnStatus) {
		super();
		this.returnId = returnId;
		this.orderId = orderId;
		this.productId = productId;
		this.pickupDate = pickupDate;
		this.returnStatus = returnStatus;
	}
	

}