package com.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstore.dao.IInvoiceDao;
import com.capstore.model.Invoice;
import com.capstore.model.Order;

@Service("invoiceService")
public class InvoiceService implements IInvoiceService{

	@Autowired
	IInvoiceDao invoicedao;
	
	@Autowired
	IOrderService orderService;
	
	@Override
	public Invoice getInvoiceFromOrderId(int OrderId) {
		
		Order myOrder = orderService.findOrderById(OrderId);
		
		List<Invoice> invoices = invoicedao.findAll();
		
		for(Invoice myInvoice: invoices) {
			if(myInvoice.getOrder().equals(myOrder)) {
				return myInvoice;
			}
		}
		return null;
	}

	@Override
	public boolean generateInvoice(Invoice invoice) {
		
		invoicedao.save(invoice);
		
		return true;
	}
}