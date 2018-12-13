package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IInventoryMerchantDao;
import com.capstore.model.Inventory;

@Service("inventoryMerchantService")
public class InventoryMerchantService implements IInventoryMerchantService{

	@Autowired
	private IInventoryMerchantDao inventoryMerchantDao;
	
	
	@Override
	public List<Inventory> getAllInventories(int merchantId) {
		List<Inventory> inventories=inventoryMerchantDao.getAllInventoryByMerchantId(merchantId);
		
		return inventories;
	}

	@Override
	public List<Inventory> addNewInventory(Inventory inventory) {
		System.out.println("service"+inventory);
		
		inventoryMerchantDao.save(inventory);
		System.out.println("service after "+inventory);
		return null;
		
	}

	@Override
	public List<Inventory> deleteInventory(int inventoryId) {
		inventoryMerchantDao.deleteById(inventoryId);
		return null;
	}

	@Override
	public List<Inventory> updateInventory(Inventory inventory) {
		System.out.println(inventory);
		inventoryMerchantDao.save(inventory);
		return null;
	}

	@Override
	public List<Inventory> getInventoriesList() {
		
		return inventoryMerchantDao.findAll();
	}



}
