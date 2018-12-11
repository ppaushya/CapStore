package com.capstore.service;

import com.capstore.model.Invoice;

public interface IInvoiceService {

	public Invoice generateInvoice(Invoice invoice);
	public Invoice getInvoiceFromOrderId(int OrderId);

}