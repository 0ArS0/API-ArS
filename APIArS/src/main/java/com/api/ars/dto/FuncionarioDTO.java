package com.api.ars.dto;

import java.time.LocalDate;

public class FuncionarioDTO {

	private Double salario;
	private String nomeUsuario;
	private LocalDate dataContratacao;
	private Integer departamento;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Double salario, LocalDate dataContratacao, Integer departamento, String nomeUsuario) {
		super();
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.nomeUsuario = nomeUsuario;
		this.departamento = departamento;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
