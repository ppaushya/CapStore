package com.capstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Promos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int promoId;
	private String promoImageUrl;
	private String promoCode;
	private int discount;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date endDate;
	
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public String getPromoImageUrl() {
		return promoImageUrl;
	}
	public void setPromoImageUrl(String promoImageUrl) {
		this.promoImageUrl = promoImageUrl;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "Promos [promoId=" + promoId + ", promoImageUrl=" + promoImageUrl + ", promoCode=" + promoCode
				+ ", discount=" + discount + ", endDate=" + endDate + "]";
	}
	
	public Promos(int promoId, String promoImageUrl, String promoCode, int discount, Date endDate) {
		super();
		this.promoId = promoId;
		this.promoImageUrl = promoImageUrl;
		this.promoCode = promoCode;
		this.discount = discount;
		this.endDate = endDate;
	}
	public Promos() {
		super();
	}
}