package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Coupons;
@Repository("couponsDao")
@Transactional
public interface ICouponDao extends JpaRepository<Coupons,Integer>{

}
