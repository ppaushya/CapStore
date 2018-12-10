package com.capstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Merchant {
	
	@Id
	@Column(name="merchantId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int merchantId;
	private String merchantName;
	
	@Column(unique=true,name="emailId")
	private String emailId;
	
	private String merchantPassword;
	private String merchantContact;
	
	@OneToOne(targetEntity=Address.class,cascade=CascadeType.ALL)
//	@Column(name="merchantAddress")
	
	private Address merchantAddress;
	private boolean isVerified;
	
	public int getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMerchantContact() {
		return merchantContact;
	}
	public void setMerchantContact(String merchantContact) {
		this.merchantContact = merchantContact;
	}
	public Address getMerchantAddress() {
		return merchantAddress;
	}
	public void setMerchantAddress(Address merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public String getMerchantPassword() {
		return merchantPassword;
	}
	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}
	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", emailId=" + emailId
				+ ", merchantPassword=" + merchantPassword + ", merchantContact=" + merchantContact
				+ ", merchantAddress=" + merchantAddress + ", isVerified=" + isVerified + "]"
				+ ", merchantContact=" + merchantContact + ", merchantAddress="
				+ merchantAddress + ", isVerified=" + isVerified + "]";
	}
	public Merchant(int merchantId, String merchantName, String emailId, String merchantPassword,
			String merchantContact, Address merchantAddress, boolean isVerified) {
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.emailId = emailId;
		this.merchantPassword = merchantPassword;
		this.merchantContact = merchantContact;
		this.merchantAddress = merchantAddress;
		this.isVerified = isVerified;
	}
	public Merchant() {
		super();
	}
}