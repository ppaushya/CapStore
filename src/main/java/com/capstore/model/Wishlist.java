package com.capstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Wishlist {
	
	@Id
	@Column(name="wishlistId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishlistId;
	
	@Column(name="customerId")
	@OneToOne(targetEntity=Customer.class)
	private int customerId;
	
	@Column(name="products")
	@OneToMany(targetEntity=Product.class)
	private List<Product> products = new ArrayList<>();
	
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", customerId=" + customerId + ", products=" + products + "]";
	}
	public Wishlist(int wishlistId, int customerId, List<Product> products) {
		super();
		this.wishlistId = wishlistId;
		this.customerId = customerId;
		this.products = products;
	}
	public Wishlist() {
		super();
	}
}