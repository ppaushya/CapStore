package com.capstore.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstore.model.Invoice;
import com.capstore.model.Shipment;

@Repository("invoiceDao")
@Transactional
public interface IInvoiceDao extends JpaRepository<Invoice,Integer> {

}
