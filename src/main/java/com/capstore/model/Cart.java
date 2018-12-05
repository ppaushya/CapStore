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
public class Cart {
	
	@Id
	@Column(name="cartId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	
//	@Column(name="customerId")
	@OneToOne(targetEntity=Customer.class)
	private int customerId;
	
//	@Column(name="productList")
	@OneToMany(targetEntity=Product.class)
	private List<Product> products = new ArrayList<>();
	
	@Column(name="quantity")
	private int quantity;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", products=" + products + ", quantity="
				+ quantity + "]";
	}
	public Cart(int cartId, int customerId, List<Product> products, int quantity) {
		super();
		this.cartId = cartId;
		this.customerId = customerId;
		this.products = products;
		this.quantity = quantity;
	}
	public Cart() {
		super();
	}
}