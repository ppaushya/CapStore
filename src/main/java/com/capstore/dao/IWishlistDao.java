package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Wishlist;

@Repository("wishlistDao")
@Transactional
public interface IWishlistDao  extends JpaRepository<Wishlist,Integer> {

	
}
