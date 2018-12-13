package com.capstore.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IInventoryMerchantDao;
import com.capstore.model.Inventory;
import com.capstore.model.Promos;

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
		System.out.println("service"+inventory);
		
		inventoryMerchantDao.save(inventory);
		System.out.println("service after "+inventory);
		return getAllInventories();
		
	}

	@Override
	public List<Inventory> deleteInventory(int inventoryId) {
		inventoryMerchantDao.deleteById(inventoryId);
		return getAllInventories();
	}

	@Override
	public List<Inventory> updateInventory(Inventory inventory) {
		System.out.println(inventory);
		inventoryMerchantDao.save(inventory);
		return getAllInventories();
	}

	@Override
	public void editAllPromos(Promos promo, String category) {
		List<Inventory> inventories=inventoryMerchantDao.findAll();
		int x=0;
		for(Inventory inventory:inventories) {
			if(inventory.getProductCategory().equals(category)) {
				inventories.get(x).setPromo(promo);
				inventoryMerchantDao.save(inventories.get(x));
			}
			x++;
		}
	}

	

}
