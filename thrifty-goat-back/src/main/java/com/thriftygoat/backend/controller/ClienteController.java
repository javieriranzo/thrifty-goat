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

import com.thriftygoat.backend.model.Cliente;
import com.thriftygoat.backend.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    // Obtener un cliente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable(value = "id") Long clienteId) {
        Cliente cliente = clienteService.getClienteById(clienteId);
        return ResponseEntity.ok().body(cliente);
    }

    // Crear un nuevo cliente
    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        return clienteService.createCliente(cliente);
    }

    // Actualizar un cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(
            @PathVariable(value = "id") Long clienteId, 
            @RequestBody Cliente clienteDetails) {

        Cliente updatedCliente = clienteService.updateCliente(clienteId, clienteDetails);
        return ResponseEntity.ok().body(updatedCliente);
    }

    // Eliminar un cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable(value = "id") Long clienteId) {
        clienteService.deleteCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

}
