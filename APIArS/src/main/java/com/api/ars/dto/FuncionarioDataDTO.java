package com.api.ars.dto;

import java.time.LocalDate;

public class FuncionarioDataDTO {

	private String nomeCompletoFuncionario;
	private String celularFuncionario;
	private String emailFuncionario;
	private String localidadeFuncionario;
	private String cepFuncionario;
	private LocalDate dataNascimentoFuncionario;
	private LocalDate dataContratacaoFuncionario;
	private Double salarioFuncionario;

	private DepartamentoDataDTO departamentoData;

	public FuncionarioDataDTO() {
	}

	public FuncionarioDataDTO(String nomeCompletoFuncionario, String celularFuncionario, String emailFuncionario,
			String localidadeFuncionario, String cepFuncionario, LocalDate dataNascimentoFuncionario,
			LocalDate dataContratacaoFuncionario, Double salarioFuncionario, DepartamentoDataDTO departamentoData) {
		super();
		this.nomeCompletoFuncionario = nomeCompletoFuncionario;
		this.celularFuncionario = celularFuncionario;
		this.emailFuncionario = emailFuncionario;
		this.localidadeFuncionario = localidadeFuncionario;
		this.cepFuncionario = cepFuncionario;
		this.dataNascimentoFuncionario = dataNascimentoFuncionario;
		this.dataContratacaoFuncionario = dataContratacaoFuncionario;
		this.salarioFuncionario = salarioFuncionario;
		this.departamentoData = departamentoData;
	}

	public DepartamentoDataDTO getDepartamentoData() {
		return departamentoData;
	}

	public void setDepartamentoData(DepartamentoDataDTO departamentoData) {
		this.departamentoData = departamentoData;
	}

	public String getNomeCompletoFuncionario() {
		return nomeCompletoFuncionario;
	}

	public void setNomeCompletoFuncionario(String nomeCompletoFuncionario) {
		this.nomeCompletoFuncionario = nomeCompletoFuncionario;
	}

	public String getCelularFuncionario() {
		return celularFuncionario;
	}

	public void setCelularFuncionario(String celularFuncionario) {
		this.celularFuncionario = celularFuncionario;
	}

	public String getEmailFuncionario() {
		return emailFuncionario;
	}

	public void setEmailFuncionario(String emailFuncionario) {
		this.emailFuncionario = emailFuncionario;
	}

	public String getLocalidadeFuncionario() {
		return localidadeFuncionario;
	}

	public void setLocalidadeFuncionario(String localidadeFuncionario) {
		this.localidadeFuncionario = localidadeFuncionario;
	}

	public String getCepFuncionario() {
		return cepFuncionario;
	}

	public void setCepFuncionario(String cepFuncionario) {
		this.cepFuncionario = cepFuncionario;
	}

	public LocalDate getDataNascimentoFuncionario() {
		return dataNascimentoFuncionario;
	}

	public void setDataNascimentoFuncionario(LocalDate dataNascimentoFuncionario) {
		this.dataNascimentoFuncionario = dataNascimentoFuncionario;
	}

	public LocalDate getDataContratacaoFuncionario() {
		return dataContratacaoFuncionario;
	}

	public void setDataContratacaoFuncionario(LocalDate dataContratacaoFuncionario) {
		this.dataContratacaoFuncionario = dataContratacaoFuncionario;
	}

	public Double getSalarioFuncionario() {
		return salarioFuncionario;
	}

	public void setSalarioFuncionario(Double salarioFuncionario) {
		this.salarioFuncionario = salarioFuncionario;
	}

}
