package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IAddressDao;
import com.capstore.model.Address;

import ch.qos.logback.core.net.SyslogOutputStream;

@Service("addressService")
public class AddressService implements IAddressService{

	@Autowired

	IAddressDao addressdao;

	//Get all addresses
	public List<Address> getAllAddresses() {

		List<Address> add=addressdao.findAll();
		System.out.println("Service"+add);
		return addressdao.findAll();

	}

	public Address createAddress(Address address) {
		
		return addressdao.save(address) ;
	}

}