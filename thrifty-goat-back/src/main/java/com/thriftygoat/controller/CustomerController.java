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

import com.thriftygoat.model.Customer;
import com.thriftygoat.service.CustomerServiceImpl;
import com.thriftygoat.utils.ResponseFormat;
import com.thriftygoat.utils.Utils;

@Controller
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerServiceImpl;

	@GetMapping("/")
	public String home() {
		return "¡Bienvenido a mi aplicación!";
	}

	@GetMapping("/customer/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> allCustomers = customerServiceImpl.findAllCustomers();
		try {
			return new ResponseEntity<List<Customer>>(allCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/customer/getCustomerById/{id}")
	public ResponseEntity<ResponseFormat<Customer>> getCustomerById(@PathVariable Long id) {
		Customer customerById = customerServiceImpl.findCustomerById(id);
		ResponseFormat<Customer> responseFormat = new ResponseFormat<Customer>();
		try {
			if (checkIfIdIsNotValid(id)) {
				responseFormat.createBadRequestResponse(Utils.BAD_REQUEST_MESSAGE);
			}
			if (checkIfCustomerNotExists(id)) {
				responseFormat.createNotFoundResponse(Utils.NOT_FOUND_MESSAGE);
			}
		} catch (Exception e) {
			return responseFormat.createInternalServerErrorResponse(Utils.INTERNAL_SERVER_ERROR);
		}
		return responseFormat.createOkResponse(customerById);
	}

	@PostMapping("/customer/createCustomer")
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

	@PutMapping("/customer/updateCustomer/{id}")
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
			customerById.setStreet(customer.getStreet());
			customerById.setNumber(customer.getNumber());
			customerById.setPostalCode(customer.getPostalCode());
			customerById.setCity(customer.getCity());
			customerById.setState(customer.getState());
			customerById.setCountry(customer.getCountry());
			Customer updatedCustomer = customerServiceImpl.createCustomer(customerById);
			return new ResponseEntity<Customer>(updatedCustomer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/customer/deleteCustomer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id", required = true) Long id) {
		try {
			if (id == null || checkIfIdIsNotValid(id)) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			if (checkIfCustomerNotExists(id)) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		customerServiceImpl.deleteCustomer(id);
		return new ResponseEntity<String>("Cliente eliminado correctamente", HttpStatus.OK);
	}

	private boolean checkIfIdIsNotValid(Long id) {
		return id <= 0 || !(id instanceof Long);
	}

	private boolean checkIfCustomerNotExists(Long id) {
		Customer existCustomer = customerServiceImpl.findCustomerById(id);
		return existCustomer == null;
	}

	private boolean hasCustomerNullFields(Customer customer) {
		return customer.getFirstName() == null || customer.getLastName() == null || customer.getDni() == null
				|| customer.getEmail() == null || customer.getPhoneNumber() == null || customer.getStreet() == null
				|| customer.getNumber() == null || customer.getPostalCode() == null || customer.getCity() == null
				|| customer.getState() == null || customer.getCountry() == null;
	}

}
