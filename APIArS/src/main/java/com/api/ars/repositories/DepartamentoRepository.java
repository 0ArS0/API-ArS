package com.api.ars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ars.entities.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{

}
