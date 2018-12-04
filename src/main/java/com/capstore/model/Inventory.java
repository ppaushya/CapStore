package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Inventory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryId;
	
	@OneToOne(targetEntity=Merchant.class)
	private int merchantId;
	private int productName;
	private ProductCategory productCategory;
	private double productPrice;
	private String productDescription;
	
	@OneToOne(targetEntity=Promos.class)
	private int promoId;
	private String status;
	private InventoryType inventoryType;
	private int inventoryQuantity;
	
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public int getProductName() {
		return productName;
	}
	public void setProductName(int productName) {
		this.productName = productName;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public int getPromoId() {
		return promoId;
	}
	public void setPromoId(int promoId) {
		this.promoId = promoId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public InventoryType getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(InventoryType inventoryType) {
		this.inventoryType = inventoryType;
	}
	
	public int getInventoryQuantity() {
		return inventoryQuantity;
	}
	public void setInventoryQuantity(int inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}
	@Override
	public String toString() {
		return "InventoryMerchant [inventoryId=" + inventoryId + ", merchantId=" + merchantId + ", productName="
				+ productName + ", productCategory=" + productCategory + ", productPrice=" + productPrice
				+ ", productDescription=" + productDescription + ", promoId=" + promoId + ", status=" + status
				+ ", inventoryType=" + inventoryType + ", inventoryQuantity=" + inventoryQuantity + "]";
	}
	public Inventory(int inventoryId, int merchantId, int productName, ProductCategory productCategory,
			double productPrice, String productDescription, int promoId, String status, InventoryType inventoryType,int inventoryQuantity) {
		super();
		this.inventoryId = inventoryId;
		this.merchantId = merchantId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.promoId = promoId;
		this.status = status;
		this.inventoryType = inventoryType;
		this.inventoryQuantity=inventoryQuantity;
	}
	public Inventory() {
		super();
	}
}