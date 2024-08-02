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

import com.thriftygoat.backend.model.Categoria;
import com.thriftygoat.backend.service.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired
    private CategoriaService categoriaService;

    // Obtener todos los categorías
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Obtener una categoría por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable(value = "id") Long categoriaId) {
        Categoria categoria = categoriaService.getCategoriaById(categoriaId);
        return ResponseEntity.ok().body(categoria);
    }

    // Crear una nueva categoría
    @PostMapping
    public Categoria createCategoria(@RequestBody Categoria categoria) {
        return categoriaService.createCategoria(categoria);
    }

    // Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(
            @PathVariable(value = "id") Long categoriaId, 
            @RequestBody Categoria categoriaDetails) {

        Categoria updatedCategoria = categoriaService.updateCategoria(categoriaId, categoriaDetails);
        return ResponseEntity.ok().body(updatedCategoria);
    }

    // Eliminar una categoría
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable(value = "id") Long categoriaId) {
        categoriaService.deleteCategoria(categoriaId);
        return ResponseEntity.noContent().build();
    }

}
