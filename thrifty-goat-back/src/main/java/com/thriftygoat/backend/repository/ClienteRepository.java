package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thriftygoat.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
