package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Email;

@Repository("emailDao")
@Transactional
public interface IEmailDao extends JpaRepository<Email,Integer>  {

}
