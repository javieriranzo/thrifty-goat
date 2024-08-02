package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.ClienteProducto;
import com.thriftygoat.backend.repository.ClienteProductoRepository;

@Service
public class ClienteProductoService {

	@Autowired
	private ClienteProductoRepository clienteProductoRepository;
	
	// Obtener todos los ClienteProducto
    public List<ClienteProducto> getAllClienteProductos() {
        return clienteProductoRepository.findAll();
    }

    // Obtener un ClienteProducto por su ID compuesto (clienteId y productoId)
    public ClienteProducto getClienteProductoById(Long clienteId, Long productoId) {
        return clienteProductoRepository.findById(new ClienteProducto.ClienteProductoId(clienteId, productoId))
                .orElseThrow(() -> new ResourceNotFoundException("ClienteProducto not found for clienteId :: " + clienteId + " and productoId :: " + productoId));
    }

    // Crear un nuevo ClienteProducto
    public ClienteProducto createClienteProducto(ClienteProducto clienteProducto) {
        return clienteProductoRepository.save(clienteProducto);
    }

    // Actualizar un ClienteProducto existente
    public ClienteProducto updateClienteProducto(Long clienteId, Long productoId, ClienteProducto clienteProductoDetails) {
        ClienteProducto clienteProducto = clienteProductoRepository.findById(new ClienteProducto.ClienteProductoId(clienteId, productoId))
                .orElseThrow(() -> new ResourceNotFoundException("ClienteProducto not found for clienteId :: " + clienteId + " and productoId :: " + productoId));

        clienteProducto.setCliente(clienteProductoDetails.getCliente());
        clienteProducto.setProducto(clienteProductoDetails.getProducto());

        return clienteProductoRepository.save(clienteProducto);
    }

    // Eliminar un ClienteProducto
    public void deleteClienteProducto(Long clienteId, Long productoId) {
        ClienteProducto clienteProducto = clienteProductoRepository.findById(new ClienteProducto.ClienteProductoId(clienteId, productoId))
                .orElseThrow(() -> new ResourceNotFoundException("ClienteProducto not found for clienteId :: " + clienteId + " and productoId :: " + productoId));
        clienteProductoRepository.delete(clienteProducto);
    }
	
}
