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

import com.thriftygoat.backend.model.Direccion;
import com.thriftygoat.backend.service.DireccionService;

@RestController
@RequestMapping("/api/direcciones")
public class DireccionController {
	
	@Autowired
    private DireccionService direccionService;

    // Obtener todas las direcciones
    @GetMapping
    public List<Direccion> getAllDirecciones() {
        return direccionService.getAllDirecciones();
    }

    // Obtener una dirección por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Direccion> getDireccionById(@PathVariable(value = "id") Long direccionId) {
        Direccion direccion = direccionService.getDireccionById(direccionId);
        return ResponseEntity.ok().body(direccion);
    }

    // Crear una nueva dirección
    @PostMapping
    public Direccion createDireccion(@RequestBody Direccion direccion) {
        return direccionService.createDireccion(direccion);
    }

    // Actualizar una dirección existente
    @PutMapping("/{id}")
    public ResponseEntity<Direccion> updateDireccion(
            @PathVariable(value = "id") Long direccionId, 
            @RequestBody Direccion direccionDetails) {

        Direccion updatedDireccion = direccionService.updateDireccion(direccionId, direccionDetails);
        return ResponseEntity.ok().body(updatedDireccion);
    }

    // Eliminar una dirección
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDireccion(@PathVariable(value = "id") Long direccionId) {
        direccionService.deleteDireccion(direccionId);
        return ResponseEntity.noContent().build();
    }

}
