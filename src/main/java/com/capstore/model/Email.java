package com.capstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Email {
	
	@Id
	@GeneratedValue
	private int serialNo;
	private String emailId;
	private String message;
	private String imageUrl;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
		return "Email [serialNo=" + serialNo + ", emailId=" + emailId + ", message=" + message + ", imageUrl="
				+ imageUrl + "]";
	}
	public Email(int serialNo, String emailId, String message, String imageUrl) {
		super();
		this.serialNo = serialNo;
		this.emailId = emailId;
		this.message = message;
		this.imageUrl = imageUrl;
	}
	public Email() {
		super();
	}
}