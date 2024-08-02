package com.thriftygoat.backend.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.Categoria;
import com.thriftygoat.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	// Obtener todas las categorías
	public List<Categoria> getAllCategorias() {
		return categoriaRepository.findAll();
	}

	// Obtener una categoría por su ID
	public Categoria getCategoriaById(Long id) {
		return categoriaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));
	}

	// Crear una nueva categoría
	public Categoria createCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	// Actualizar una categoría existente
	public Categoria updateCategoria(Long id, Categoria categoriaDetails) {
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));

		categoria.setNombreCategoria(categoriaDetails.getNombreCategoria());
		categoria.setDescripcionCategoria(categoriaDetails.getDescripcionCategoria());

		return categoriaRepository.save(categoria);
	}

	// Eliminar una categoría
	public void deleteCategoria(Long id) {
		Categoria categoria = categoriaRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Categoria not found for this id :: " + id));
		categoriaRepository.delete(categoria);
	}

}
