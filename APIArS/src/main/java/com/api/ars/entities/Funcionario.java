package com.api.ars.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*
	 * Nome Completo
	 * 
	 * Data de Nascimento
	 * 
	 * Gênero
	 * 
	 * Cargo
	 * 
	 * Departamento
	 * 
	 * Data de Contratação
	 * 
	 * Salário
	 * 
	 * Endereço
	 * 
	 * Telefone
	 * 
	 * E-mail
	 */

}
