package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thriftygoat.backend.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
