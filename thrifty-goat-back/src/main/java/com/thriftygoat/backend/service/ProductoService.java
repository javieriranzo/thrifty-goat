package com.thriftygoat.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thriftygoat.backend.exception.ResourceNotFoundException;
import com.thriftygoat.backend.model.Producto;
import com.thriftygoat.backend.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;
	
	// Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por su ID
    public Producto getProductoById(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));
    }

    // Crear un nuevo producto
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto updateProducto(Long id, Producto productoDetails) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));

        producto.setCategoria(productoDetails.getCategoria());
        producto.setNombreProducto(productoDetails.getNombreProducto());
        producto.setDescripcionProducto(productoDetails.getDescripcionProducto());
        producto.setPrecio(productoDetails.getPrecio());

        return productoRepository.save(producto);
    }

    // Eliminar un producto
    public void deleteProducto(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto not found for this id :: " + id));
        productoRepository.delete(producto);
    }
	
}
