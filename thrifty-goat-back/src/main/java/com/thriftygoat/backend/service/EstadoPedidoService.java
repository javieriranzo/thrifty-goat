package com.thriftygoat.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thriftygoat.backend.repository.EstadoPedidoRepository;

@Service
public class EstadoPedidoService {

	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
	
}
