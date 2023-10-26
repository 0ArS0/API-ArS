package com.api.ars.dto;

import java.time.LocalDate;

public class FuncionarioDTO {

	private Double salario;
	private LocalDate dataContratacao;
	private Integer departamento;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Double salario, LocalDate dataContratacao, Integer departamento) {
		super();
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.departamento = departamento;
	}

	public Integer getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Integer departamento) {
		this.departamento = departamento;
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
}
