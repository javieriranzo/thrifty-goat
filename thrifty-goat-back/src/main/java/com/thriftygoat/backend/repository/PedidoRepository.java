package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thriftygoat.backend.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}