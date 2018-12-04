package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int invoiceNo;
	
	@OneToOne(targetEntity=Order.class)
	private int orderId;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date InvoiceDate;
	private double discountedPrice;
	private double discount;
	
	@OneToOne(targetEntity=Coupons.class)
	private int couponId;
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getInvoiceDate() {
		return InvoiceDate;
	}
	public void setInvoiceDate(Date invoiceDate) {
		InvoiceDate = invoiceDate;
	}
	public double getDiscountedPrice() {
		return discountedPrice;
	}
	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getPromoId() {
		return couponId;
	}
	public void setPromoId(int couponId) {
		this.couponId = couponId;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceNo=" + invoiceNo + ", orderId=" + orderId + ", InvoiceDate=" + InvoiceDate
				+ ", discountedPrice=" + discountedPrice + ", discount=" + discount + ", promoId=" + couponId + "]";
	}
	public Invoice(int invoiceNo, int orderId, Date invoiceDate, double discountedPrice, double discount, int couponId) {
		super();
		this.invoiceNo = invoiceNo;
		this.orderId = orderId;
		InvoiceDate = invoiceDate;
		this.discountedPrice = discountedPrice;
		this.discount = discount;
		this.couponId = couponId;
	}
	public Invoice() {
		super();
	}
}