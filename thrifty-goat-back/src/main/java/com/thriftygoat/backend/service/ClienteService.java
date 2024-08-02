package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.Cliente;
import com.thriftygoat.backend.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	// Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + id));
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente existente
    public Cliente updateCliente(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + id));

        cliente.setNombre(clienteDetails.getNombre());
        cliente.setApellidos(clienteDetails.getApellidos());
        cliente.setDni(clienteDetails.getDni());
        cliente.setEmail(clienteDetails.getEmail());
        cliente.setPrefijoPais(clienteDetails.getPrefijoPais());
        cliente.setTelefono(clienteDetails.getTelefono());
        cliente.setDireccion(clienteDetails.getDireccion());

        return clienteRepository.save(cliente);
    }

    // Eliminar un cliente
    public void deleteCliente(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente not found for this id :: " + id));
        clienteRepository.delete(cliente);
    }
    
}
