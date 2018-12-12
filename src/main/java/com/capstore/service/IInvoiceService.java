package com.capstore.service;

import com.capstore.model.Invoice;

public interface IInvoiceService {

	public boolean generateInvoice(Invoice invoice);
	public Invoice getInvoiceFromOrderId(int OrderId);

}