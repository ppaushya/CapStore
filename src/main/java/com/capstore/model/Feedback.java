package com.capstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Feedback {

	@Id
	@Column(name="feedbackId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int feedbackId;
	
	@Column(name="customerId")
	@OneToOne(targetEntity=Customer.class)
	private int customerId;
	
	@Column(name="productId")
	@OneToOne(targetEntity=Product.class)
	private int productId;
	@Column(name="ratingProduct")
	private double ratingProduct;
	@Column(name="ratingMerchant")
	private double ratingMerchant;
	@Column(name="comment")
	private String comment;
	
	@Column(name="merchantId")
	@OneToOne(targetEntity=Merchant.class)
	private int merchantId;
	
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
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
	
	public double getRatingProduct() {
		return ratingProduct;
	}
	public void setRatingProduct(double ratingProduct) {
		this.ratingProduct = ratingProduct;
	}
	public double getRatingMerchant() {
		return ratingMerchant;
	}
	public void setRatingMerchant(double ratingMerchant) {
		this.ratingMerchant = ratingMerchant;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerId=" + customerId + ", productId=" + productId
				+ ", ratingProduct=" + ratingProduct + ", ratingMerchant=" + ratingMerchant + ", comment=" + comment
				+ ", merchantId=" + merchantId + "]";
	}
	
	public Feedback(int feedbackId, int customerId, int productId, double ratingProduct, double ratingMerchant,
			String comment, int merchantId) {
		super();
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.productId = productId;
		this.ratingProduct = ratingProduct;
		this.ratingMerchant = ratingMerchant;
		this.comment = comment;
		this.merchantId = merchantId;
	}
	public Feedback() {
		super();
	}
}