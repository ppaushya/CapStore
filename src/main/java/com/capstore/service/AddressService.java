package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IAddressDao;
import com.capstore.model.Address;
import com.capstore.model.Customer;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service("addressService")
public class AddressService implements IAddressService{

	@Autowired

	IAddressDao addressDao;

	//Get all addresses
	public List<Address> getAllAddresses() {

		List<Address> add=addressDao.findAll();
		System.out.println("Service"+add);
		return addressDao.findAll();

	}

	public Address createAddress(Address address) {
		
		return addressDao.save(address) ;
	}

	

}