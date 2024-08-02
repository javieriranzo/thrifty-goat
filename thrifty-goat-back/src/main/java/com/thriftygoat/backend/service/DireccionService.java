package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.Direccion;
import com.thriftygoat.backend.repository.DireccionRepository;

@Service
public class DireccionService {

	@Autowired
	private DireccionRepository direccionRepository;
	
	// Obtener todas las direcciones
    public List<Direccion> getAllDirecciones() {
        return direccionRepository.findAll();
    }

    // Obtener una direccion por su ID
    public Direccion getDireccionById(Long id) {
        return direccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion not found for this id :: " + id));
    }

    // Crear una nueva direccion
    public Direccion createDireccion(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    // Actualizar una direccion existente
    public Direccion updateDireccion(Long id, Direccion direccionDetails) {
        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion not found for this id :: " + id));

        direccion.setDireccion(direccionDetails.getDireccion());
        direccion.setCiudad(direccionDetails.getCiudad());
        direccion.setProvincia(direccionDetails.getProvincia());
        direccion.setCodigoPostal(direccionDetails.getCodigoPostal());
        direccion.setPais(direccionDetails.getPais());

        return direccionRepository.save(direccion);
    }

    // Eliminar una direccion
    public void deleteDireccion(Long id) {
        Direccion direccion = direccionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Direccion not found for this id :: " + id));
        direccionRepository.delete(direccion);
    }
	
}
