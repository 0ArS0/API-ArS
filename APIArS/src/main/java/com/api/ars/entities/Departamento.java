package com.api.ars.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_departamento")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * Nome do Departamento
	 * 
	 * Descrição
	 * 
	 * Data de Criação
	 * 
	 * Funcionários
	 * 
	 * Orçamento
	 * 
	 * Endereço
	 * 
	 * Telefone
	 * 
	 * E-mail
	 */
	
	
}
