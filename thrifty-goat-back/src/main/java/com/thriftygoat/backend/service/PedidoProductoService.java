package com.thriftygoat.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thriftygoat.backend.repository.PedidoProductoRepository;

@Service
public class PedidoProductoService {

	@Autowired
	private PedidoProductoRepository pedidoProductoRepository;
	
}
