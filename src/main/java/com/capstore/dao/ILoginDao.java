package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Login;

@Repository("loginDao")
@Transactional
public interface ILoginDao extends JpaRepository<Login,Integer>{

}
