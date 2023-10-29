package com.api.ars.dto;

import java.time.LocalDate;

public class GerenteDataDTO {

	private String nomeCompletoGerente;
	private String celularGerente;
	private String emailGerente;
	private String localidadeGerente;
	private String cepGerente;
	private LocalDate dataNascimentoGerente;
	private LocalDate dataContratacaoGerente;
	private Double salarioGerente;

	private DepartamentoDataDTO departamentoData;

	public GerenteDataDTO() {
	}

	public GerenteDataDTO(String nomeCompletoGerente, String celularGerente, String emailGerente,
			String localidadeGerente, String cepGerente, LocalDate dataNascimentoGerente,
			LocalDate dataContratacaoGerente, Double salarioGerente, DepartamentoDataDTO departamentoData) {
		super();
		this.nomeCompletoGerente = nomeCompletoGerente;
		this.celularGerente = celularGerente;
		this.emailGerente = emailGerente;
		this.localidadeGerente = localidadeGerente;
		this.cepGerente = cepGerente;
		this.dataNascimentoGerente = dataNascimentoGerente;
		this.dataContratacaoGerente = dataContratacaoGerente;
		this.salarioGerente = salarioGerente;
		this.departamentoData = departamentoData;
	}

	public DepartamentoDataDTO getDepartamentoData() {
		return departamentoData;
	}

	public void setDepartamentoData(DepartamentoDataDTO departamentoData) {
		this.departamentoData = departamentoData;
	}

	public String getNomeCompletoGerente() {
		return nomeCompletoGerente;
	}

	public void setNomeCompletoGerente(String nomeCompletoGerente) {
		this.nomeCompletoGerente = nomeCompletoGerente;
	}

	public String getCelularGerente() {
		return celularGerente;
	}

	public void setCelularGerente(String celularGerente) {
		this.celularGerente = celularGerente;
	}

	public String getEmailGerente() {
		return emailGerente;
	}

	public void setEmailGerente(String emailGerente) {
		this.emailGerente = emailGerente;
	}

	public String getLocalidadeGerente() {
		return localidadeGerente;
	}

	public void setLocalidadeGerente(String localidadeGerente) {
		this.localidadeGerente = localidadeGerente;
	}

	public String getCepGerente() {
		return cepGerente;
	}

	public void setCepGerente(String cepGerente) {
		this.cepGerente = cepGerente;
	}

	public LocalDate getDataNascimentoGerente() {
		return dataNascimentoGerente;
	}

	public void setDataNascimentoGerente(LocalDate dataNascimentoGerente) {
		this.dataNascimentoGerente = dataNascimentoGerente;
	}

	public LocalDate getDataContratacaoGerente() {
		return dataContratacaoGerente;
	}

	public void setDataContratacaoGerente(LocalDate dataContratacaoGerente) {
		this.dataContratacaoGerente = dataContratacaoGerente;
	}

	public Double getSalarioGerente() {
		return salarioGerente;
	}

	public void setSalarioGerente(Double salarioGerente) {
		this.salarioGerente = salarioGerente;
	}

}
