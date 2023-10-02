package com.thriftygoat.model;

import java.util.Date;

public class InoviceHeader {

	private Long id; 
	private String invoiceNumber; 
	private Date invoiceDate;
	private Customer invoiceCustomer; 
	private String invoicePaymentMethod;
	
	public InoviceHeader() {}
	
	public InoviceHeader(Long id, String invoiceNumber, Date invoiceDate, Customer invoiceCustomer,
			String invoicePaymentMethod) {
		this.id = id;
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.invoiceCustomer = invoiceCustomer;
		this.invoicePaymentMethod = invoicePaymentMethod;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Customer getInvoiceCustomer() {
		return invoiceCustomer;
	}

	public void setInvoiceCustomer(Customer invoiceCustomer) {
		this.invoiceCustomer = invoiceCustomer;
	}

	public String getInvoicePaymentMethod() {
		return invoicePaymentMethod;
	}

	public void setInvoicePaymentMethod(String invoicePaymentMethod) {
		this.invoicePaymentMethod = invoicePaymentMethod;
	} 	
	
}
