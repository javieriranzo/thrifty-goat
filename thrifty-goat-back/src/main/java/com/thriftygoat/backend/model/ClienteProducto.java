package com.thriftygoat.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ClienteProducto {
    
	@Id
    private Long clienteId;
    @Id
    private Long productoId;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Producto producto;
    
    public ClienteProducto() {
    }

	public ClienteProducto(Long clienteId, Long productoId, Cliente cliente, Producto producto) {
		super();
		this.clienteId = clienteId;
		this.productoId = productoId;
		this.cliente = cliente;
		this.producto = producto;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
    
}
