package com.capstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IInvoiceDao;
import com.capstore.model.Invoice;

@Service("invoiceService")
public class InvoiceService implements IInvoiceService{

	
	@Autowired
	IInvoiceDao invoicedao;
	
	@Override
	public Invoice insertinvoice(Invoice invoice) {
		// TODO Auto-generated method stub
		return invoicedao.save(invoice);
	}

}
