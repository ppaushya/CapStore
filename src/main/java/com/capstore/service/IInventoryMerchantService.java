package com.capstore.service;

import java.util.List;

import com.capstore.model.Inventory;

public interface IInventoryMerchantService {

	
	
	public List<Inventory> getAllInventories();

    public List<Inventory> addNewInventory(Inventory inventory);

	public List<Inventory> deleteInventory(Integer inventoryId);

	public List<Inventory> updateInventory(Inventory inventory);
}
