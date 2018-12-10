package com.capstore.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="productOrder")
public class Order {
	
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId;

	@OneToOne(targetEntity=Customer.class)
	private Customer customer;
	
	@OneToOne(targetEntity=Product.class)
	private Cart cart;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date orderDate;
	
	private int quantity;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customer=" + customer + ", cart=" + cart + ", orderDate=" + orderDate
				+ ", quantity=" + quantity + "]";
	}

	public Order(int orderId, Customer customer, Cart cart, Date orderDate, int quantity) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.cart = cart;
		this.orderDate = orderDate;
		this.quantity = quantity;
	}

	

	
	
	
}