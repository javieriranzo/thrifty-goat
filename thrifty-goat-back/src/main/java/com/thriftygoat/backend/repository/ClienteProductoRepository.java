package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thriftygoat.backend.model.ClienteProducto;

@Repository
public interface ClienteProductoRepository extends JpaRepository<ClienteProducto, Long>{

}
