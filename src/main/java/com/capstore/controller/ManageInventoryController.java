package com.capstore.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.capstore.model.Inventory;
import com.capstore.model.Merchant;
import com.capstore.model.Promos;
import com.capstore.service.IInventoryMerchantService;
import com.capstore.service.IMerchantService;
import com.capstore.service.IProductService;
import com.capstore.service.IPromoService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ManageInventoryController {
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IInventoryMerchantService inventoryMerchantService;
	
	@Autowired
	IPromoService promoService;
	
	@Autowired
	IMerchantService merchantService;
	
	Merchant merchant;
	

	@GetMapping("/inventories/{mailId}")
	public ResponseEntity<List<Inventory>> getAllInventories(@PathVariable("mailId") String mailId){
		
		merchant=merchantService.getMerchantByMail(mailId);
		List<Inventory> inventories=inventoryMerchantService.getAllInventories(merchant.getMerchantId());
		System.out.println(inventories);
		if(inventories.isEmpty())
			 return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
		
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
		
	}
	
	

	@PostMapping("/editInventories/{mailId}")
	public ResponseEntity<Boolean> editInventory(@RequestBody Inventory inventory,
		 @PathVariable("mailId") String mailId){
		
		System.out.println(inventory);
		
		merchant=merchantService.getMerchantByMail(mailId);
		System.out.println("this"+merchant);
		inventory.setMerchant(merchant);
		inventory.setInventoryType("MERCHANT");
		System.out.println(merchant);
		
		
		inventoryMerchantService.addNewInventory(inventory);
		productService.editProduct(inventory);
		List<Inventory> inventories=inventoryMerchantService.getAllInventories(merchant.getMerchantId());
		
		if(inventories.isEmpty())
			 return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
	
	@PostMapping("/addInventories/{mailId}")
	public ResponseEntity<Boolean> addNewInventory(@RequestBody Inventory inventory,
		 @PathVariable("mailId") String mailId){
		
		System.out.println(inventory);
		
		merchant=merchantService.getMerchantByMail(mailId);
		System.out.println("this"+merchant);
		inventory.setMerchant(merchant);
		inventory.setInventoryType("MERCHANT");
		System.out.println(merchant);
		
		
		inventoryMerchantService.addNewInventory(inventory);
		
		List<Inventory> inventories=inventoryMerchantService.getAllInventories(merchant.getMerchantId());
		if(inventories.isEmpty())
			 return new ResponseEntity<Boolean>(false,HttpStatus.OK);
		
		return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		
	}
	

	
	@DeleteMapping(value="/inventories/{inventoryId}")
    public ResponseEntity<Boolean>deleteInventory(@PathVariable("inventoryId")int inventoryId){
	
		
	   inventoryMerchantService.deleteInventory(inventoryId);
	   //List<Inventory> inventories=inventoryMerchantService.getAllInventories(merchantId);
	
/*//	   if(inventories==null)
//		  return new ResponseEntity("Sorry!! Inventory Id not available!",HttpStatus.NOT_FOUND);
*/	
	return new ResponseEntity(true,HttpStatus.OK);
	
}
	

	@PutMapping("/inventories")
	public ResponseEntity<List<Inventory>>updateInventory(@RequestBody Inventory inventory){
		List<Inventory> inventories=inventoryMerchantService.updateInventory(inventory);
		
		if(inventories==null)
			  return new ResponseEntity("Sorry!! Inventory Id not available",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
	}
	
	@PostMapping("/inventories/promo")
	public ResponseEntity<Boolean> addPromo(@RequestBody Promos promo)
	{
		promoService.addPromo(promo);
		return new ResponseEntity(true,HttpStatus.OK);
	}
	
	
	
}
