package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	private String productName;
	private ProductCategory productCategory;
	
	@OneToOne(targetEntity=Inventory.class)
	private int inventoryId;
	private double productPrice;
	
	@OneToOne(targetEntity=Merchant.class)
	private int merchantId;
	
	@OneToOne(targetEntity=Promos.class)
	private int promoId;
	private int productsSold;
	private int productView;
	private boolean isPromotionMessageSent;
	private String productDescription;
	private int quantity;
	private double discount;
	
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
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", inventoryId=" + inventoryId + ", productPrice=" + productPrice + ", merchantId="
				+ merchantId + ", promoId=" + promoId + ", productsSold=" + productsSold + ", productView="
				+ productView + ", isPromotionMessageSent=" + isPromotionMessageSent + ", productDescription="
				+ productDescription + ", quantity=" + quantity + ", discount=" + discount + "]";
	}
	public Product(int productId, String productName, ProductCategory productCategory, int inventoryId,
			double productPrice, int merchantId, int promoId, int productsSold, int productView,
			boolean isPromotionMessageSent, String productDescription, int quantity, double discount) {
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
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.discount = discount;
	}
	public Product() {
		super();
	}
}