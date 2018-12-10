package com.capstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	
	@OneToOne(targetEntity=Customer.class)
	private Customer customer;
	
//	@Column(name="products")
	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();
	
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", customer=" + customer + ", products=" + products + "]";
	}
	
	public Wishlist(int wishlistId, Customer customer, List<Product> products) {
		super();
		this.wishlistId = wishlistId;
		this.customer = customer;
		this.products = products;
	}
	public Wishlist() {
		super();
	}
}