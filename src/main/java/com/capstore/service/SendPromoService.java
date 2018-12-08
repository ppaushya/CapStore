package com.capstore.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.model.Customer;
import com.capstore.model.Email;
import com.capstore.model.Product;

@Service("sendPromoService")
public class SendPromoService implements ISendPromoService{

	@Autowired
	IEmailService emailService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	ICustomerService customerService;
	
	@Override
	public boolean sendPromotionalEmailToUser(Email email) { //Team 6
		emailService.sendEmailToCustomer(email);
		return true;
	}
	
	@Override
	public boolean checkIfPromotionalEmailsRequiredToBeSent() { //Team 6
		List<Product> productsWithoutEmailSent = productService.getProductsWithoutPromotionalEmailSent();
		if(productsWithoutEmailSent.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean sendPromotionalEmailsToAllCustomer() { //Team 6
		List<Customer> customers = customerService.getAllCustomers();
		
		//get all products without email sent
		List<Product> productsWithoutEmailSent = productService.getProductsWithoutPromotionalEmailSent();
		if(productsWithoutEmailSent.isEmpty()) {
			return false;
		}
				
		Email email = getNewProductEmail(productsWithoutEmailSent);
		
		for(Customer customer : customers) {
			Email customerEmail = new Email();
			BeanUtils.copyProperties(email,customerEmail);
			customerEmail.setReceiverEmailId(customer.getEmailId());
			sendPromotionalEmailToUser(customerEmail);
		}
		
		markPromotionalEmailsSent(productsWithoutEmailSent);
		return true;
	}

	@Override
	public Email getNewProductEmail(List<Product> products) { //Team 6
		//make email
		Email email = new Email();
		email.setImageUrl("no image");
		email.setSenderEmailId("promotion@capstore.com");
		email.setMessage(getEmailContentFromProductList(products));
		
		return email;
	}

	@Override
	public boolean markPromotionalEmailsSent(List<Product> products) {
		for(Product product:products) {
			product.setPromotionMessageSent(true);
			productService.updateProduct(product);
		}
		return true;
	}

	private String getEmailContentFromProductList(List<Product> products) { //Team 6
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getHeadingForEmail());
		stringBuilder.append("\nWe have added following new products in our inventory. Let's have a look...!\n\n");
		stringBuilder.append("ProductName"+"\t"+
				"Brand"+"\t"+
				"Discount"+"\n");
		for(Product product:products) {
			stringBuilder.append(product.getProductName()+"\t"+
					product.getBrand()+"\t"+
					product.getDiscount()+"\n");
		}
		stringBuilder.append("Hope you find them useful :)\n");
		stringBuilder.append(getFooterForEmail());
		
		return stringBuilder.toString();
	}
	
	private String getHeadingForEmail() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\r\n" + 
				"                                                                                                                                  \r\n" + 
				"    ,o888888o.           .8.          8 888888888o     d888888o. 8888888 8888888888 ,o888888o.     8 888888888o.   8 8888888888   \r\n" + 
				"   8888     `88.        .888.         8 8888    `88. .`8888:' `88.     8 8888    . 8888     `88.   8 8888    `88.  8 8888         \r\n" + 
				",8 8888       `8.      :88888.        8 8888     `88 8.`8888.   Y8     8 8888   ,8 8888       `8b  8 8888     `88  8 8888         \r\n" + 
				"88 8888               . `88888.       8 8888     ,88 `8.`8888.         8 8888   88 8888        `8b 8 8888     ,88  8 8888         \r\n" + 
				"88 8888              .8. `88888.      8 8888.   ,88'  `8.`8888.        8 8888   88 8888         88 8 8888.   ,88'  8 888888888888 \r\n" + 
				"88 8888             .8`8. `88888.     8 888888888P'    `8.`8888.       8 8888   88 8888         88 8 888888888P'   8 8888         \r\n" + 
				"88 8888            .8' `8. `88888.    8 8888            `8.`8888.      8 8888   88 8888        ,8P 8 8888`8b       8 8888         \r\n" + 
				"`8 8888       .8' .8'   `8. `88888.   8 8888        8b   `8.`8888.     8 8888   `8 8888       ,8P  8 8888 `8b.     8 8888         \r\n" + 
				"   8888     ,88' .888888888. `88888.  8 8888        `8b.  ;8.`8888     8 8888    ` 8888     ,88'   8 8888   `8b.   8 8888         \r\n" + 
				"    `8888888P'  .8'       `8. `88888. 8 8888         `Y8888P ,88P'     8 8888       `8888888P'     8 8888     `88. 8 888888888888 \r\n" + 
				"");
		stringBuilder.append("\n\n\nGreeting from CapStore\n\n");
		return stringBuilder.toString();
	}
	
	private String getFooterForEmail() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\nHave a nice day");
		return stringBuilder.toString();
	}

}
