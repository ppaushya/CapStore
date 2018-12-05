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
	private String emailIds;
	private String message;
	private String imageUrl;
	
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getEmailId() {
		return emailIds;
	}
	public void setEmailId(String emailIds) {
		this.emailIds = emailIds;
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
		return "Email [serialNo=" + serialNo + ", emailId=" + emailIds + ", message=" + message + ", imageUrl="
				+ imageUrl + "]";
	}
	public Email(int serialNo, String emailIds, String message, String imageUrl) {
		super();
		this.serialNo = serialNo;
		this.emailIds = emailIds;
		this.message = message;
		this.imageUrl = imageUrl;
	}
	public Email() {
		super();
	}
}