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
import com.thriftygoat.backend.model.Pedido;
import com.thriftygoat.backend.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
	
	@Autowired
    private PedidoService pedidoService;

    // Obtener todos los pedidos
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    // Obtener un pedido por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable(value = "id") Long pedidoId) {
        Pedido pedido = pedidoService.getPedidoById(pedidoId);
        return ResponseEntity.ok().body(pedido);
    }

    // Crear un nuevo pedido
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.createPedido(pedido);
    }

    // Actualizar un pedido existente
    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(
            @PathVariable(value = "id") Long pedidoId,
            @RequestBody Pedido pedidoDetails) {

        Pedido updatedPedido = pedidoService.updatePedido(pedidoId, pedidoDetails);
        return ResponseEntity.ok().body(updatedPedido);
    }

    // Eliminar un pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable(value = "id") Long pedidoId) {
        pedidoService.deletePedido(pedidoId);
        return ResponseEntity.noContent().build();
    }

}
