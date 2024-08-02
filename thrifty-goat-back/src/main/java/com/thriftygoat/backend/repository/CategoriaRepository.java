package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thriftygoat.backend.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
