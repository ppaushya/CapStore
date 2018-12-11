package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serialNo;
	@OneToOne(targetEntity=Customer.class)
	private Customer customer;
	@OneToOne(targetEntity=Product.class)
	private Product product;
	private int quantity;

	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "CartProduct [serialNo=" + serialNo + ", customer=" + customer + ", product=" + product + ", quantity="
				+ quantity + "]";
	}
	public CartProduct(int serialNo, Customer customer, Product product, int quantity) {
		super();
		this.serialNo = serialNo;
		this.customer = customer;
		this.product = product;
		this.quantity = quantity;
	}
	public CartProduct() {
		super();
	}
}