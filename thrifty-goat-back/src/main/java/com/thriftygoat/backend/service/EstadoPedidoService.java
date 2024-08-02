package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.EstadoPedido;
import com.thriftygoat.backend.repository.EstadoPedidoRepository;

@Service
public class EstadoPedidoService {

	@Autowired
	private EstadoPedidoRepository estadoPedidoRepository;
	
	// Obtener todos los estados de pedidos
    public List<EstadoPedido> getAllEstadoPedidos() {
        return estadoPedidoRepository.findAll();
    }

    // Obtener un estado de pedido por su ID
    public EstadoPedido getEstadoPedidoById(Long id) {
        return estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoPedido not found for this id :: " + id));
    }

    // Crear un nuevo estado de pedido
    public EstadoPedido createEstadoPedido(EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    // Actualizar un estado de pedido existente
    public EstadoPedido updateEstadoPedido(Long id, EstadoPedido estadoPedidoDetails) {
        EstadoPedido estadoPedido = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoPedido not found for this id :: " + id));

        estadoPedido.setNombreEstado(estadoPedidoDetails.getNombreEstado());
        estadoPedido.setAbreviaturaEstado(estadoPedidoDetails.getAbreviaturaEstado());

        return estadoPedidoRepository.save(estadoPedido);
    }

    // Eliminar un estado de pedido
    public void deleteEstadoPedido(Long id) {
        EstadoPedido estadoPedido = estadoPedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("EstadoPedido not found for this id :: " + id));
        estadoPedidoRepository.delete(estadoPedido);
    }
	
}
