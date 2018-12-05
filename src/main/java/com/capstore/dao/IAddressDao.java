package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Address;

@Repository("addressDao")
@Transactional
public interface IAddressDao extends JpaRepository<Address,Integer>{
	
}
