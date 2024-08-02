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

import com.thriftygoat.backend.model.ClienteProducto;
import com.thriftygoat.backend.service.ClienteProductoService;

@RestController
@RequestMapping("/api/clientes-productos")
public class ClienteProductoController {
	
	@Autowired
    private ClienteProductoService clienteProductoService;

    // Obtener todas las relaciones cliente-producto
    @GetMapping
    public List<ClienteProducto> getAllClienteProductos() {
        return clienteProductoService.getAllClienteProductos();
    }

    // Obtener una relación cliente-producto por cliente_id y producto_id
    @GetMapping("/{clienteId}/{productoId}")
    public ResponseEntity<ClienteProducto> getClienteProductoById(
            @PathVariable(value = "clienteId") Long clienteId,
            @PathVariable(value = "productoId") Long productoId) {

        ClienteProducto clienteProducto = clienteProductoService.getClienteProductoById(clienteId, productoId);
        return ResponseEntity.ok().body(clienteProducto);
    }

    // Crear una nueva relación cliente-producto
    @PostMapping
    public ClienteProducto createClienteProducto(@RequestBody ClienteProducto clienteProducto) {
        return clienteProductoService.createClienteProducto(clienteProducto);
    }

    // Actualizar una relación cliente-producto existente
    @PutMapping("/{clienteId}/{productoId}")
    public ResponseEntity<ClienteProducto> updateClienteProducto(
            @PathVariable(value = "clienteId") Long clienteId,
            @PathVariable(value = "productoId") Long productoId,
            @RequestBody ClienteProducto clienteProductoDetails) {

        ClienteProducto updatedClienteProducto = clienteProductoService.updateClienteProducto(clienteId, productoId, clienteProductoDetails);
        return ResponseEntity.ok().body(updatedClienteProducto);
    }

    // Eliminar una relación cliente-producto
    @DeleteMapping("/{clienteId}/{productoId}")
    public ResponseEntity<Void> deleteClienteProducto(
            @PathVariable(value = "clienteId") Long clienteId,
            @PathVariable(value = "productoId") Long productoId) {

        clienteProductoService.deleteClienteProducto(clienteId, productoId);
        return ResponseEntity.noContent().build();
    }

}
