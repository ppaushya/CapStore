package com.capstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Inventory {

	@Id
	@Column(name="inventoryId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryId;
	
//	@Column(name="merchantId")
	@OneToOne(targetEntity=Merchant.class)
	private int merchantId;
	@Column(name="productName")
	private String productName;
	@Column(name="productCategory")
	private String productCategory;
	@Column(name="productPrice")
	private double productPrice;
	@Column(name="productDescription")
	private String productDescription;
	
//	@Column(name="promoId")
	@OneToOne(targetEntity=Promos.class)
	private int promoId;
	@Column(name="status")
	private String status;
	@Column(name="inventoryType")
	private String inventoryType;
	@Column(name="inventoryQuantity")
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
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
	public String getInventoryType() {
		return inventoryType;
	}
	public void setInventoryType(String inventoryType) {
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
	public Inventory(int inventoryId, int merchantId, String productName, String productCategory,
			double productPrice, String productDescription, int promoId, String status, String inventoryType,int inventoryQuantity) {
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