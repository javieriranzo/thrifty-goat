package com.thriftygoat.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.thriftygoat.backend.model.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Long> {

}
