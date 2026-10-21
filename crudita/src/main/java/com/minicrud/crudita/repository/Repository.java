package com.minicrud.crudita.repository;

import com.minicrud.crudita.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository<Persona, Long>{
}
