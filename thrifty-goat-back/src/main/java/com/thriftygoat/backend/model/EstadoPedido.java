package com.thriftygoat.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EstadoPedido {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreEstado;
    private String abreviaturaEstado;
    
    public EstadoPedido() {
    }

	public EstadoPedido(Long id, String nombreEstado, String abreviaturaEstado) {
		super();
		this.id = id;
		this.nombreEstado = nombreEstado;
		this.abreviaturaEstado = abreviaturaEstado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getAbreviaturaEstado() {
		return abreviaturaEstado;
	}

	public void setAbreviaturaEstado(String abreviaturaEstado) {
		this.abreviaturaEstado = abreviaturaEstado;
	}
    
    
    
}

