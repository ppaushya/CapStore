package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int imageId;
	
	@OneToOne(targetEntity=Product.class)
	private int productId;
	private String imageUrl;
	private ImageStatus imageStatus;
	
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
	public ImageStatus getImageStatus() {
		return imageStatus;
	}
	public void setImageStatus(ImageStatus imageStatus) {
		this.imageStatus = imageStatus;
	}
	@Override
	public String toString() {
		return "ProductImage [imageId=" + imageId + ", productId=" + productId + ", imageUrl=" + imageUrl
				+ ", imageStatus=" + imageStatus + "]";
	}
	public ProductImage(int imageId, int productId, String imageUrl, ImageStatus imageStatus) {
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