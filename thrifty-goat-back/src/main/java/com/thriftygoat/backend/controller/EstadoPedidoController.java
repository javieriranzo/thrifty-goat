package com.thriftygoat.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thriftygoat.backend.model.EstadoPedido;
import com.thriftygoat.backend.service.EstadoPedidoService;

@RestController
@RequestMapping("/api/estado-pedidos")
public class EstadoPedidoController {

	@Autowired
	private EstadoPedidoService estadoPedidoService;

	// Obtener todos los estados de pedido
	@GetMapping
	public List<EstadoPedido> getAllEstadoPedidos() {
		return estadoPedidoService.getAllEstadoPedidos();
	}

	// Obtener un estado de pedido por su ID
	@GetMapping("/{id}")
	public ResponseEntity<EstadoPedido> getEstadoPedidoById(@PathVariable(value = "id") Long estadoPedidoId) {
		EstadoPedido estadoPedido = estadoPedidoService.getEstadoPedidoById(estadoPedidoId);
		return ResponseEntity.ok().body(estadoPedido);
	}

	// Crear un nuevo estado de pedido
	@PostMapping
	public EstadoPedido createEstadoPedido(@RequestBody EstadoPedido estadoPedido) {
		return estadoPedidoService.createEstadoPedido(estadoPedido);
	}

	// Actualizar un estado de pedido existente
	@PutMapping("/{id}")
	public ResponseEntity<EstadoPedido> updateEstadoPedido(@PathVariable(value = "id") Long estadoPedidoId,
			@RequestBody EstadoPedido estadoPedidoDetails) {

		EstadoPedido updatedEstadoPedido = estadoPedidoService.updateEstadoPedido(estadoPedidoId, estadoPedidoDetails);
		return ResponseEntity.ok().body(updatedEstadoPedido);
	}

	// Eliminar un estado de pedido
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEstadoPedido(@PathVariable(value = "id") Long estadoPedidoId) {
		estadoPedidoService.deleteEstadoPedido(estadoPedidoId);
		return ResponseEntity.noContent().build();
	}

}
