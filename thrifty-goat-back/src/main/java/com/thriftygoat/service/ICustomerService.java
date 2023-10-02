package com.thriftygoat.service;

import java.util.List;

import com.thriftygoat.model.Customer;

public interface ICustomerService {

	public List<Customer> findAllCustomers();
	public Customer findCustomerById(Long id); 
	public Customer createCustomer(Customer customer);
	public void deleteCustomer(Long id); 
	
}
