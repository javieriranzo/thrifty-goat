package com.thriftygoat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.thriftygoat.model.Address;
import com.thriftygoat.model.Customer;
import com.thriftygoat.service.CustomerServiceImpl;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl customerServiceImpl; 
	
	@GetMapping("customers/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> allCustomers = customerServiceImpl.findAllCustomers();
		try {
			return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customerById = customerServiceImpl.findCustomerById(id);
		try {
			if (checkIfIdIsNotValid(id)) {
				return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			}
			if (checkIfCustomerNotExists(id)) {
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			} 
			return new ResponseEntity<Customer>(customerById, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer newCustomer = customerServiceImpl.createCustomer(customer);
		try {
			if (hasCustomerNullFields(newCustomer)) {
				return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Customer>(newCustomer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
		Customer customerById = customerServiceImpl.findCustomerById(id); 
		try {
			if (checkIfIdIsNotValid(id)) {
				return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
			}
			if (checkIfCustomerNotExists(id)) {
				return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			}
			customerById.setFirstName(customer.getFirstName()); 
			customerById.setLastName(customer.getLastName());
			customerById.setDni(customer.getDni());
			customerById.setEmail(customer.getEmail());
			customerById.setPhoneNumber(customer.getPhoneNumber());
			customerById.setAddress(customer.getAddress());
			Customer updatedCustomer = customerServiceImpl.createCustomer(customerById);
			return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED); 
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		try {
			if (checkIfIdIsNotValid(id)) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			if(checkIfCustomerNotExists(id)) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			customerServiceImpl.deleteCustomer(id); 
			return new ResponseEntity<String>("Cliente eliminado correctamente", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private boolean checkIfIdIsNotValid(Long id) {
		return id == null || id <= 0; 
	}
	
	private boolean checkIfCustomerNotExists(Long id) {
		Customer existCustomer = customerServiceImpl.findCustomerById(id); 
		return existCustomer == null; 
	}
	
	private boolean hasCustomerNullFields(Customer customer) {
		return customer.getFirstName() == null ||
			   customer.getLastName() == null ||
			   customer.getDni() == null ||
			   customer.getEmail() == null ||
			   customer.getPhoneNumber() == null ||
			   hasCustomerNullFields(customer.getAddress());
	}
	
	private boolean hasCustomerNullFields(Address address) {
		return address.getStreet() == null ||
			   address.getNumber() == null ||
			   address.getPostalCode() == null ||
			   address.getCity() == null ||
			   address.getState() == null ||
			   address.getCountry() == null;
	}
		
}
