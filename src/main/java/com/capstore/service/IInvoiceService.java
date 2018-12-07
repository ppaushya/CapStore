package com.capstore.service;

import com.capstore.model.Invoice;

public interface IInvoiceService {

	public Invoice insertInvoice(Invoice invoice);
	public Invoice getInvoiceFromOrderId(int OrderId);

}
