package com.api.ars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.ars.entities.Gerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer>{

}
