package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.Pedido;
import com.thriftygoat.backend.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	   // Obtener todos los pedidos
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    // Obtener un pedido por su ID
    public Pedido getPedidoById(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + id));
    }

    // Crear un nuevo pedido
    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    // Actualizar un pedido existente
    public Pedido updatePedido(Long id, Pedido pedidoDetails) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + id));

        pedido.setClienteId(pedidoDetails.getClienteId());
        pedido.setProductoId(pedidoDetails.getProductoId());
        pedido.setDireccionId(pedidoDetails.getDireccionId());
        pedido.setFechaInicio(pedidoDetails.getFechaInicio());
        pedido.setFechaFinalizacion(pedidoDetails.getFechaFinalizacion());
        pedido.setEstadoId(pedidoDetails.getEstadoId());

        return pedidoRepository.save(pedido);
    }

    // Eliminar un pedido
    public void deletePedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido not found for this id :: " + id));
        pedidoRepository.delete(pedido);
    }
	
}
