package com.capstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	
	@Id
	@Column(name="transactionId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int transactionId;
	
//	@Column(name="orderId")
	@OneToOne(targetEntity=Order.class)
	private int orderId;
	
//	@Column(name="invoiceNo")
	@OneToOne(targetEntity=Invoice.class)
	private int invoiceNo;
	private String modeOfPayment;
	private String paymentModeNumber;
	private String status;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public int getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getPaymentModeNumber() {
		return paymentModeNumber;
	}
	public void setPaymentModeNumber(String paymentModeNumber) {
		this.paymentModeNumber = paymentModeNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", orderId=" + orderId + ", invoiceNo=" + invoiceNo
				+ ", modeOfPayment=" + modeOfPayment + ", paymentModeNumber=" + paymentModeNumber + ", status=" + status
				+ "]";
	}
	
	public Transaction(int transactionId, int orderId, int invoiceNo, String modeOfPayment,
			String paymentModeNumber, String status) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.invoiceNo = invoiceNo;
		this.modeOfPayment = modeOfPayment;
		this.paymentModeNumber = paymentModeNumber;
		this.status = status;
	}
	public Transaction() {
		super();
	}
}