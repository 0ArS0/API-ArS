package com.api.ars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer id;

	@NotNull
	@Column(name = "salario")
	private Double salario;

	@NotNull
	@Column(name = "data_contratacao")
	private LocalDate dataContratacao;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Funcionario() {
	}

	public Funcionario(Integer id, @NotNull Double salario, @NotNull LocalDate dataContratacao,
			Departamento departamento) {
		this.id = id;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.departamento = departamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public LocalDate getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(LocalDate dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

}
