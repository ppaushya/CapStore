package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CartProducts {
	
	@Id
	private int serialNo;
	@ManyToOne
	private Cart cart;
	@OneToOne
	private Product product;
	private int quantity;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartProducts [serialNo=" + serialNo + ", cart=" + cart + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	public CartProducts(int serialNo, Cart cart, Product product, int quantity) {
		super();
		this.serialNo = serialNo;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}
	public CartProducts() {
		super();
	}
}