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
public class Invoice {
	
	@Id
	@Column(name="invoiceNo")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int invoiceNo;
	
//	@Column(name="orderId")
	@OneToOne(targetEntity=Order.class)
	private Order order;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	
	private Date InvoiceDate;
	private double discountedPrice;
	private double discount;
	
//	@Column(name="couponId")
	@OneToOne(targetEntity=Coupons.class)
	private Coupons coupon;
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Coupons getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupons coupon) {
		this.coupon = coupon;
	}
	@Override
	public String toString() {
		return "Invoice [invoiceNo=" + invoiceNo + ", order=" + order + ", InvoiceDate=" + InvoiceDate
				+ ", discountedPrice=" + discountedPrice + ", discount=" + discount + ", coupon=" + coupon + "]";
	}
	public Invoice(int invoiceNo, Order order, Date invoiceDate, double discountedPrice, double discount,
			Coupons coupon) {
		super();
		this.invoiceNo = invoiceNo;
		this.order = order;
		InvoiceDate = invoiceDate;
		this.discountedPrice = discountedPrice;
		this.discount = discount;
		this.coupon = coupon;
	}
	public Invoice() {
		super();
	}
}