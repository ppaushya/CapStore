package com.capstore.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstore.model.Inventory;

@Repository("inventoryMerchantDao")
@Transactional
public interface IInventoryMerchantDao extends JpaRepository<Inventory,Integer> {

}
