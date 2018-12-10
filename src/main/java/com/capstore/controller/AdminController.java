package com.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capstore.model.Customer;
import com.capstore.model.Inventory;
import com.capstore.model.Login;
import com.capstore.model.Merchant;
import com.capstore.service.ICustomerService;
import com.capstore.service.IInventoryMerchantService;
import com.capstore.service.IMerchantService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class AdminController {
	
	@Autowired
	public ICustomerService customerService;
	
	@Autowired
	public IMerchantService merchantService;
	
	@Autowired
	IInventoryMerchantService inventoryMerchantService;
	

	
//	**************************Customers**************************************

	@GetMapping(value = "/customers/all")
	public ResponseEntity<java.util.List<Customer>> getAllCustomers() {
		System.out.println("");
		java.util.List<Customer> list_of_customers = customerService.getAllCustomers();
		System.out.println("Controller"+list_of_customers);
		if (list_of_customers==null) {
			new ResponseEntity("No Customers found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<java.util.List<Customer>>(list_of_customers, HttpStatus.OK);
	}
	
	
//	************************Merchants**********************************************
	
	@GetMapping(value = "/merchants/all")
	public ResponseEntity<java.util.List<Merchant>> getAllMerchants() {
		System.out.println("");
		java.util.List<Merchant> list_of_merchants = merchantService.getAllMerchants();
		System.out.println("Controller"+list_of_merchants);
		if (list_of_merchants==null) {
			new ResponseEntity("No Merchants found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<java.util.List<Merchant>>(list_of_merchants, HttpStatus.OK);
	}
	
	//admin verifies Merchant by clicking on approve button
	@RequestMapping("/merchantVerification")
	public ResponseEntity<List<Merchant>> verifyMerchant_On_clicking_Approve_BUTTON(@RequestBody Merchant merchant) {
		
		List<Merchant> list_of_verified_merchants=merchantService.getAllMerchants();
		
	 
	    
	    merchant.setVerified(true);
	    Login login = new Login();
	    login.setEmailId(merchant.getEmailId());
	    login.setPassword(merchant.getMerchantPassword());
	    login.setUserTypes("MERCHANT");
        merchantService.updateMerchant(merchant);	
        
		
		return new ResponseEntity<List<Merchant>>(list_of_verified_merchants,HttpStatus.OK);
	}
	
	
	//admin removes Merchant by clicking on reject button
	@RequestMapping("/merchantReject")
	public ResponseEntity<List<Merchant>> rejectMerchant_On_clicking_Reject_BUTTON(@RequestBody Merchant merchant){
		
		List<Merchant> list_of_verified_merchants=merchantService.getAllMerchants();
		
	
	    merchant.setVerified(false);
	    System.out.println("\r\n" + 
	    		"                                                                                                                                                                                                                                                                                                          \r\n" + 
	    		"                                         dddddddd                                                                                                                                                                                         dddddddd                                                        \r\n" + 
	    		"               AAA                       d::::::d                        iiii                                                              jjjj                                               tttt                                        d::::::d     YYYYYYY       YYYYYYY                              \r\n" + 
	    		"              A:::A                      d::::::d                       i::::i                                                            j::::j                                           ttt:::t                                        d::::::d     Y:::::Y       Y:::::Y                              \r\n" + 
	    		"             A:::::A                     d::::::d                        iiii                                                              jjjj                                            t:::::t                                        d::::::d     Y:::::Y       Y:::::Y                              \r\n" + 
	    		"            A:::::::A                    d:::::d                                                                                                                                           t:::::t                                        d:::::d      Y::::::Y     Y::::::Y                              \r\n" + 
	    		"           A:::::::::A           ddddddddd:::::d   mmmmmmm    mmmmmmm  iiiiiinnnn  nnnnnnnn         rrrrr   rrrrrrrrr      eeeeeeeeeeee  jjjjjjj   eeeeeeeeeeee       cccccccccccccccttttttt:::::ttttttt       eeeeeeeeeeee       ddddddddd:::::d      YYY:::::Y   Y:::::YYooooooooooo  uuuuuu    uuuuuu  \r\n" + 
	    		"          A:::::A:::::A        dd::::::::::::::d mm:::::::m  m:::::::mmi:::::n:::nn::::::::nn       r::::rrr:::::::::r   ee::::::::::::eej:::::j ee::::::::::::ee   cc:::::::::::::::t:::::::::::::::::t     ee::::::::::::ee   dd::::::::::::::d         Y:::::Y Y:::::Yoo:::::::::::oou::::u    u::::u  \r\n" + 
	    		"         A:::::A A:::::A      d::::::::::::::::dm::::::::::mm::::::::::mi::::n::::::::::::::nn      r:::::::::::::::::r e::::::eeeee:::::ej::::je::::::eeeee:::::eec:::::::::::::::::t:::::::::::::::::t    e::::::eeeee:::::eed::::::::::::::::d          Y:::::Y:::::Yo:::::::::::::::u::::u    u::::u  \r\n" + 
	    		"        A:::::A   A:::::A    d:::::::ddddd:::::dm::::::::::::::::::::::mi::::nn:::::::::::::::n     rr::::::rrrrr::::::e::::::e     e:::::j::::e::::::e     e:::::c:::::::cccccc:::::tttttt:::::::tttttt   e::::::e     e:::::d:::::::ddddd:::::d           Y:::::::::Y o:::::ooooo:::::u::::u    u::::u  \r\n" + 
	    		"       A:::::A     A:::::A   d::::::d    d:::::dm:::::mmm::::::mmm:::::mi::::i n:::::nnnn:::::n      r:::::r     r:::::e:::::::eeeee::::::j::::e:::::::eeeee::::::c::::::c     ccccccc     t:::::t         e:::::::eeeee::::::d::::::d    d:::::d            Y:::::::Y  o::::o     o::::u::::u    u::::u  \r\n" + 
	    		"      A:::::AAAAAAAAA:::::A  d:::::d     d:::::dm::::m   m::::m   m::::mi::::i n::::n    n::::n      r:::::r     rrrrrre:::::::::::::::::ej::::e:::::::::::::::::ec:::::c                  t:::::t         e:::::::::::::::::ed:::::d     d:::::d             Y:::::Y   o::::o     o::::u::::u    u::::u  \r\n" + 
	    		"     A:::::::::::::::::::::A d:::::d     d:::::dm::::m   m::::m   m::::mi::::i n::::n    n::::n      r:::::r           e::::::eeeeeeeeeee j::::e::::::eeeeeeeeeee c:::::c                  t:::::t         e::::::eeeeeeeeeee d:::::d     d:::::d             Y:::::Y   o::::o     o::::u::::u    u::::u  \r\n" + 
	    		"    A:::::AAAAAAAAAAAAA:::::Ad:::::d     d:::::dm::::m   m::::m   m::::mi::::i n::::n    n::::n      r:::::r           e:::::::e          j::::e:::::::e          c::::::c     ccccccc     t:::::t    ttttte:::::::e          d:::::d     d:::::d             Y:::::Y   o::::o     o::::u:::::uuuu:::::u  \r\n" + 
	    		"   A:::::A             A:::::d::::::ddddd::::::dm::::m   m::::m   m::::i::::::in::::n    n::::n      r:::::r           e::::::::e         j::::e::::::::e         c:::::::cccccc:::::c     t::::::tttt:::::e::::::::e         d::::::ddddd::::::dd            Y:::::Y   o:::::ooooo:::::u:::::::::::::::uu\r\n" + 
	    		"  A:::::A               A:::::d:::::::::::::::::m::::m   m::::m   m::::i::::::in::::n    n::::n      r:::::r            e::::::::eeeeeeee j::::je::::::::eeeeeeee  c:::::::::::::::::c     tt::::::::::::::te::::::::eeeeeeee  d:::::::::::::::::d         YYYY:::::YYYYo:::::::::::::::ou:::::::::::::::u\r\n" + 
	    		" A:::::A                 A:::::d:::::::::ddd::::m::::m   m::::m   m::::i::::::in::::n    n::::n      r:::::r             ee:::::::::::::e j::::j ee:::::::::::::e   cc:::::::::::::::c       tt:::::::::::tt ee:::::::::::::e   d:::::::::ddd::::d         Y:::::::::::Y oo:::::::::::oo  uu::::::::uu:::u\r\n" + 
	    		"AAAAAAA                   AAAAAAddddddddd   ddddmmmmmm   mmmmmm   mmmmmiiiiiiiinnnnnn    nnnnnn      rrrrrrr               eeeeeeeeeeeeee j::::j   eeeeeeeeeeeeee     cccccccccccccccc         ttttttttttt     eeeeeeeeeeeeee    ddddddddd   ddddd         YYYYYYYYYYYYY   ooooooooooo      uuuuuuuu  uuuu\r\n" + 
	    		"                                                                                                                                          j::::j                                                                                                                                                          \r\n" + 
	    		"                                                                                                                                jjjj      j::::j                                                                                                                                                          \r\n" + 
	    		"                                                                                                                               j::::jj   j:::::j                                                                                                                                                          \r\n" + 
	    		"                                                                                                                               j::::::jjj::::::j                                                                                                                                                          \r\n" + 
	    		"                                                                                                                                jj::::::::::::j                                                                                                                                                           \r\n" + 
	    		"                                                                                                                                  jjj::::::jjj                                                                                                                                                            \r\n" + 
	    		"                                                                                                                                     jjjjjj                                                                                                                                                               \r\n" + 
	    		"");
	    
	    merchantService.updateMerchant(merchant);
		
		
		return new ResponseEntity<List<Merchant>>(list_of_verified_merchants,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	************************Inventory(Products)**********************************************
	
	
	

	@GetMapping("/AdminInventories")
	public ResponseEntity<List<Inventory>> getAllInventories(){
		
		
		List<Inventory> inventories=inventoryMerchantService.getAllInventories();
		if(inventories.isEmpty())
			 return new ResponseEntity("Sorry ! Inventories not available!",HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
		
	}
	
	@PostMapping("/addInventory")
	public ResponseEntity<List<Inventory>> addNewInventory(@RequestBody Inventory inventory){
		
		System.out.println(inventory);
		List<Inventory> inventories=inventoryMerchantService.addNewInventory(inventory);
		
		if(inventories.isEmpty())
			 return new ResponseEntity("Sorry!! Inventory List not available!",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value="/AdminInventories/{inventoryId}")
    public ResponseEntity<List<Inventory>>deleteInventory(@PathVariable("inventoryId")int inventoryId){
	
	   List<Inventory> inventories=inventoryMerchantService.deleteInventory(inventoryId);
	
	   if(inventories==null)
		  return new ResponseEntity("Sorry!! Inventory Id not available!",HttpStatus.NOT_FOUND);
	
	return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
	
}
	
	@PutMapping(value="/AdminInventories")
	public ResponseEntity<List<Inventory>>updateInventory(@RequestBody Inventory inventory){
		List<Inventory> inventories=inventoryMerchantService.updateInventory(inventory);
		
		if(inventories==null)
			  return new ResponseEntity("Sorry!! Inventory Id not available",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
	
	}
	
	
//	************************Promotions**********************************************
	
	
	
	
	
	
	
	
	
	
//	************************Generate Coupons**********************************************
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	************************Generate Business Analysis**********************************************
	
	

	
	
	
	
	
	
}
