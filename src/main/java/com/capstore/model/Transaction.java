package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue
	private int transactionId;
	
	@OneToOne(mappedBy="Order")
	private int orderId;
	
	@OneToOne(mappedBy="Invoice")
	private int invoiceNo;
	private ModeOfPayment modeOfPayment;
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
	public ModeOfPayment getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(ModeOfPayment modeOfPayment) {
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
	
	public Transaction(int transactionId, int orderId, int invoiceNo, ModeOfPayment modeOfPayment,
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