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
	@OneToOne(targetEntity=Customer.class)
	private Customer customer;
	private double minimumAmount;

	/*@OneToMany(targetEntity=Product.class)
	private List<Product> products = new ArrayList<>();
	@Column(name="quantity")
	private int quantity;*/
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", minimumAmount=" + minimumAmount + "]";
	}
	public Cart(int cartId, Customer customer, double minimumAmount) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.minimumAmount = minimumAmount;
	}
	public Cart() {
		super();
	}
}