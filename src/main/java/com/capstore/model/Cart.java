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
public class Cart {
	
	@Id
	@Column(name="cartId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	@OneToOne(targetEntity=Customer.class)
	private Customer customer;
	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
	private List<CartProduct> cartProducts = new ArrayList<>();
	private int minimumAmount;

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
	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}
	public int getMinimumAmount() {
		return minimumAmount;
	}
	public void setMinimumAmount(int minimumAmount) {
		this.minimumAmount = minimumAmount;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customer=" + customer + ", cartProducts=" + cartProducts
				+ ", minimumAmount=" + minimumAmount + "]";
	}
	public Cart(int cartId, Customer customer, List<CartProduct> cartProducts, int minimumAmount) {
		super();
		this.cartId = cartId;
		this.customer = customer;
		this.cartProducts = cartProducts;
		this.minimumAmount = minimumAmount;
	}	
	public Cart()
	{
		
	}
}