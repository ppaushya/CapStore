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
	private Merchant merchant;
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
	private Promos promo;
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
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public Promos getPromo() {
		return promo;
	}
	public void setPromo(Promos promo) {
		this.promo = promo;
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
		return "Inventory [inventoryId=" + inventoryId + ", merchant=" + merchant + ", productName=" + productName
				+ ", productCategory=" + productCategory + ", productPrice=" + productPrice + ", productDescription="
				+ productDescription + ", promo=" + promo + ", status=" + status + ", inventoryType=" + inventoryType
				+ ", inventoryQuantity=" + inventoryQuantity + "]";
	}
	public Inventory(int inventoryId, Merchant merchant, String productName, String productCategory,
			double productPrice, String productDescription, Promos promo, String status, String inventoryType,
			int inventoryQuantity) {
		super();
		this.inventoryId = inventoryId;
		this.merchant = merchant;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.promo = promo;
		this.status = status;
		this.inventoryType = inventoryType;
		this.inventoryQuantity = inventoryQuantity;
	}
	public Inventory() {
		super();
	}
}