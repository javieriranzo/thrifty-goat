package com.thriftygoat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thriftygoat.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> { 
}
