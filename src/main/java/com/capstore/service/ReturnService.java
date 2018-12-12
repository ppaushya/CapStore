package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IReturnDao;
import com.capstore.model.Return;

@Service("returnService")
public class ReturnService implements IReturnService{

	@Autowired
	public IReturnDao returnDao;
	
	@Override
	public List<Return> getAllReturnDetails() {
		return returnDao.findAll();
	}

}
