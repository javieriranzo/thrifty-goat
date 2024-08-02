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
import com.thriftygoat.backend.model.PedidoProducto;
import com.thriftygoat.backend.service.PedidoProductoService;

@RestController
@RequestMapping("/api/pedido-productos")
public class PedidoProductoController {
	
	@Autowired
    private PedidoProductoService pedidoProductoService;

    // Obtener todos los pedido-productos
    @GetMapping
    public List<PedidoProducto> getAllPedidoProductos() {
        return pedidoProductoService.getAllPedidoProductos();
    }

    // Obtener un pedido-producto por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PedidoProducto> getPedidoProductoById(@PathVariable(value = "id") Long pedidoProductoId) {
        PedidoProducto pedidoProducto = pedidoProductoService.getPedidoProductoById(pedidoProductoId);
        return ResponseEntity.ok().body(pedidoProducto);
    }

    // Crear un nuevo pedido-producto
    @PostMapping
    public PedidoProducto createPedidoProducto(@RequestBody PedidoProducto pedidoProducto) {
        return pedidoProductoService.createPedidoProducto(pedidoProducto);
    }

    // Actualizar un pedido-producto existente
    @PutMapping("/{id}")
    public ResponseEntity<PedidoProducto> updatePedidoProducto(
            @PathVariable(value = "id") Long pedidoProductoId,
            @RequestBody PedidoProducto pedidoProductoDetails) {

        PedidoProducto updatedPedidoProducto = pedidoProductoService.updatePedidoProducto(pedidoProductoId, pedidoProductoDetails);
        return ResponseEntity.ok().body(updatedPedidoProducto);
    }

    // Eliminar un pedido-producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedidoProducto(@PathVariable(value = "id") Long pedidoProductoId) {
        pedidoProductoService.deletePedidoProducto(pedidoProductoId);
        return ResponseEntity.noContent().build();
    }

}
