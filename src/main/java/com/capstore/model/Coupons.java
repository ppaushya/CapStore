package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Coupons {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int couponId;
	private String couponImageUrl;
	private double maxDiscount;
	private String couponCode;
	private double discountPercentage;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date endDate;
	
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public double getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	public String getCouponImageUrl() {
		return couponImageUrl;
	}
	public void setCouponImageUrl(String couponImageUrl) {
		this.couponImageUrl = couponImageUrl;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Coupons [couponId=" + couponId + ", couponImageUrl=" + couponImageUrl + ", maxDiscount=" + maxDiscount
				+ ", couponCode=" + couponCode + ", discountPercentage=" + discountPercentage + ", endDate=" + endDate
				+ "]";
	}
	
	public Coupons(int couponId, String couponImageUrl, double maxDiscount, String couponCode,
			double discountPercentage, Date endDate) {
		super();
		this.couponId = couponId;
		this.couponImageUrl = couponImageUrl;
		this.maxDiscount = maxDiscount;
		this.couponCode = couponCode;
		this.discountPercentage = discountPercentage;
		this.endDate = endDate;
	}
	public Coupons() {
		super();
	}
}