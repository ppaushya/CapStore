package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private ProductCategory productCategory;
	
	@OneToOne(mappedBy="Inventory")
	private int inventoryId;
	private double productPrice;
	
	@OneToOne(mappedBy="Merchant")
	private int merchantId;
	
	@OneToOne(mappedBy="Promos")
	private int promoId;
	private int productsSold;
	private int productView;
	private boolean isPromotionMessageSent;
	private int quantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public int getProductsSold() {
		return productsSold;
	}
	public void setProductsSold(int productsSold) {
		this.productsSold = productsSold;
	}
	public int getProductView() {
		return productView;
	}
	public void setProductView(int productView) {
		this.productView = productView;
	}
	public boolean isPromotionMessageSent() {
		return isPromotionMessageSent;
	}
	public void setPromotionMessageSent(boolean isPromotionMessageSent) {
		this.isPromotionMessageSent = isPromotionMessageSent;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", inventoryId=" + inventoryId + ", productPrice=" + productPrice + ", merchantId="
				+ merchantId + ", promoId=" + promoId + ", productsSold=" + productsSold + ", productView="
				+ productView + ", isPromotionMessageSent=" + isPromotionMessageSent + ", quantity=" + quantity + "]";
	}
	
	public Product(int productId, String productName, ProductCategory productCategory, int inventoryId,
			double productPrice, int merchantId, int promoId, int productsSold, int productView,
			boolean isPromotionMessageSent, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.inventoryId = inventoryId;
		this.productPrice = productPrice;
		this.merchantId = merchantId;
		this.promoId = promoId;
		this.productsSold = productsSold;
		this.productView = productView;
		this.isPromotionMessageSent = isPromotionMessageSent;
		this.quantity = quantity;
	}
	public Product() {
		super();
	}
}