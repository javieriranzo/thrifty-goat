package com.thriftygoat.backend.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedido {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Direccion direccion;
    @ManyToOne
    private EstadoPedido estado;
    private Date fechaInicio;
    private Date fechaFinalizacion;
    
    public Pedido() {
    }

	public Pedido(Long id, Cliente cliente, Producto producto, Direccion direccion, EstadoPedido estado,
			Date fechaInicio, Date fechaFinalizacion) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.producto = producto;
		this.direccion = direccion;
		this.estado = estado;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}
        
}
