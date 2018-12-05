package com.capstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductImage {
	
	@Id
	@Column(name="imageId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int imageId;
	
//	@Column(name="productId")
	@OneToOne(targetEntity=Product.class)
	private int productId;
	private String imageUrl;
	private String imageStatus;
	
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getString() {
		return imageStatus;
	}
	public void setString(String imageStatus) {
		this.imageStatus = imageStatus;
	}
	@Override
	public String toString() {
		return "ProductImage [imageId=" + imageId + ", productId=" + productId + ", imageUrl=" + imageUrl
				+ ", String=" + imageStatus + "]";
	}
	public ProductImage(int imageId, int productId, String imageUrl, String String) {
		super();
		this.imageId = imageId;
		this.productId = productId;
		this.imageUrl = imageUrl;
		this.imageStatus = imageStatus;
	}
	public ProductImage() {
		super();
	}
}