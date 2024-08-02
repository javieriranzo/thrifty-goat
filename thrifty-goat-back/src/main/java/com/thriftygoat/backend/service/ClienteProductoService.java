package com.thriftygoat.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thriftygoat.backend.repository.ClienteProductoRepository;

@Service
public class ClienteProductoService {

	@Autowired
	private ClienteProductoRepository clienteProductoRepository;
	
}
