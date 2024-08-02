package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.PedidoProducto;
import com.thriftygoat.backend.repository.PedidoProductoRepository;

@Service
public class PedidoProductoService {

	@Autowired
	private PedidoProductoRepository pedidoProductoRepository;
	
	// Obtener todos los productos de los pedidos
    public List<PedidoProducto> getAllPedidoProductos() {
        return pedidoProductoRepository.findAll();
    }

    // Obtener un producto de pedido por su ID
    public PedidoProducto getPedidoProductoById(Long id) {
        return pedidoProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PedidoProducto not found for this id :: " + id));
    }

    // Crear un nuevo producto de pedido
    public PedidoProducto createPedidoProducto(PedidoProducto pedidoProducto) {
        return pedidoProductoRepository.save(pedidoProducto);
    }

    // Actualizar un producto de pedido existente
    public PedidoProducto updatePedidoProducto(Long id, PedidoProducto pedidoProductoDetails) {
        PedidoProducto pedidoProducto = pedidoProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PedidoProducto not found for this id :: " + id));

        pedidoProducto.setProducto(pedidoProductoDetails.getProducto());
        pedidoProducto.setCantidad(pedidoProductoDetails.getCantidad());

        return pedidoProductoRepository.save(pedidoProducto);
    }

    // Eliminar un producto de pedido
    public void deletePedidoProducto(Long id) {
        PedidoProducto pedidoProducto = pedidoProductoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PedidoProducto not found for this id :: " + id));
        pedidoProductoRepository.delete(pedidoProducto);
    }
    
}
