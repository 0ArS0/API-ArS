package com.api.ars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.ars.entities.Setor;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

	
	@Query(value = "select * from tb_setor where nome_setor = :nome", nativeQuery = true)
	Setor findByNome(String nome);
}
