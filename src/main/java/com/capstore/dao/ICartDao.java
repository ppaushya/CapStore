package com.capstore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstore.model.Cart;

@Repository("cartDao")
@Transactional
public interface ICartDao extends JpaRepository<Cart, Integer> {

}
