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

import com.capstore.model.Inventory;
import com.capstore.service.IInventoryMerchantService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class ManageInventoryController {
	
	@Autowired
	IInventoryMerchantService inventoryMerchantService;
	

	@GetMapping("/inventories")
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
	

	
	@DeleteMapping(value="/inventories/{inventoryId}")
    public ResponseEntity<List<Inventory>>deleteInventory(@PathVariable("inventoryId")int inventoryId){
	
	   List<Inventory> inventories=inventoryMerchantService.deleteInventory(inventoryId);
	
	   if(inventories==null)
		  return new ResponseEntity("Sorry!! Inventory Id not available!",HttpStatus.NOT_FOUND);
	
	return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
	
}
	

	@PutMapping(value="/inventories")
	public ResponseEntity<List<Inventory>>updateInventory(@RequestBody Inventory inventory){
		List<Inventory> inventories=inventoryMerchantService.updateInventory(inventory);
		
		if(inventories==null)
			  return new ResponseEntity("Sorry!! Inventory Id not available",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Inventory>>(inventories,HttpStatus.OK);
	}
	
	
	
}
