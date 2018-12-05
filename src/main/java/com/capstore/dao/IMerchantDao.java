package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capstore.model.Merchant;

@Repository("merchantDao")
@Transactional
public interface IMerchantDao extends JpaRepository<Merchant, Integer>{

}
