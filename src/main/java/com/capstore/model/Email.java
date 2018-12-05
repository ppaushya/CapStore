package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int serialNo;
	private String receiverEmailId;
	private String senderEmailId;	
	private String message;
	private String imageUrl;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getReceiverEmailId() {
		return receiverEmailId;
	}
	public void setReceiverEmailId(String receiverEmailId) {
		this.receiverEmailId = receiverEmailId;
	}
	public String getSenderEmailId() {
		return senderEmailId;
	}
	public void setSenderEmailId(String senderEmailId) {
		this.senderEmailId = senderEmailId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Email [serialNo=" + serialNo + ", receiverEmailId=" + receiverEmailId + ", senderEmailId="
				+ senderEmailId + ", message=" + message + ", imageUrl=" + imageUrl + "]";
	}
	public Email(int serialNo, String receiverEmailId, String senderEmailId, String message, String imageUrl) {
		super();
		this.serialNo = serialNo;
		this.receiverEmailId = receiverEmailId;
		this.senderEmailId = senderEmailId;
		this.message = message;
		this.imageUrl = imageUrl;
	}
	public Email() {
		super();
	}
}