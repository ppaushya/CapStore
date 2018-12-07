package com.capstore.service;

import java.util.List;

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
	public boolean sendPromotionalEmailsToAllCustomer() { //Team 6
		List<Customer> customers = customerService.getAllCustomers();
		Email email = getPromotionalEmail();
		
		for(Customer customer : customers) {
			Email customerEmail = email;
			customerEmail.setReceiverEmailId(customer.getEmailId());
			sendPromotionalEmailToUser(customerEmail);
		}
		
		return true;
	}

	@Override
	public Email getPromotionalEmail() { //Team 6
		//get all products without email sent
		List<Product> productsWithoutEmailSent = productService.getProductsWithoutPromotionalEmailSent();
		
		//make email
		Email email = new Email();
		email.setImageUrl("no image");
		email.setSenderEmailId("promotion@capstore.com");
		email.setMessage(getEmailContentFromProductList(productsWithoutEmailSent));
		
		return email;
	}
	
	private String getEmailContentFromProductList(List<Product> products) { //Team 6
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
		stringBuilder.append("Greeting from CapStore\n\n");
		stringBuilder.append("We have added following new products in our inventory. Let's have a look...!\n\n");
		stringBuilder.append("ProductName"+"\t"+
				"Brand"+"\t"+
				"Discount"+"\n");
		for(Product product:products) {
			stringBuilder.append(product.getProductName()+"\t"+
					product.getBrand()+"\t"+
					product.getDiscount()+"\n");
		}
		stringBuilder.append("Hope you find them useful :)");
		stringBuilder.append("Have a nice day");
		
		return stringBuilder.toString();
	}

}
