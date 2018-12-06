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
	public List<Inventory> getAllInventories() {
		return inventoryMerchantDao.findAll();
	}

	@Override
	public List<Inventory> addNewInventory(Inventory inventory) {
		inventoryMerchantDao.save(inventory);
		return getAllInventories();
	}

	@Override
	public List<Inventory> deleteInventory(Integer inventoryId) {
		inventoryMerchantDao.deleteById(inventoryId);
		return getAllInventories();
	}

	@Override
	public List<Inventory> updateInventory(Inventory inventory) {
		inventoryMerchantDao.save(inventory);
		return getAllInventories();
	}

}
