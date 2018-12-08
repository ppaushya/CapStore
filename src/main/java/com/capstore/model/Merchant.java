package com.capstore.model;

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
	private String password;
	
	@OneToOne
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
<<<<<<< HEAD
	public String getMerchantPassword() {
		return merchantPassword;
	}
	public void setMerchantPassword(String merchantPassword) {
		this.merchantPassword = merchantPassword;
	}
	
=======
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
	@Override
	public String toString() {
		return "Merchant [merchantId=" + merchantId + ", merchantName=" + merchantName + ", emailId=" + emailId
<<<<<<< HEAD
				+ ", merchantPassword=" + merchantPassword + ", merchantContact=" + merchantContact
				+ ", merchantAddress=" + merchantAddress + ", isVerified=" + isVerified + "]";
=======
				+ ", merchantContact=" + merchantContact + ", password=" + password + ", merchantAddress="
				+ merchantAddress + ", isVerified=" + isVerified + "]";
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
	}
<<<<<<< HEAD
	
	public Merchant(int merchantId, String merchantName, String emailId, String merchantPassword,
			String merchantContact, Address merchantAddress, boolean isVerified) {
=======
	public Merchant(int merchantId, String merchantName, String emailId, String merchantContact, String password,
			Address merchantAddress, boolean isVerified) {
>>>>>>> branch 'master' of https://github.com/ppaushya/CapStore.git
		super();
		this.merchantId = merchantId;
		this.merchantName = merchantName;
		this.emailId = emailId;
		this.merchantPassword = merchantPassword;
		this.merchantContact = merchantContact;
		this.password = password;
		this.merchantAddress = merchantAddress;
		this.isVerified = isVerified;
	}
	public Merchant() {
		super();
	}
}