package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thriftygoat.backend.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
