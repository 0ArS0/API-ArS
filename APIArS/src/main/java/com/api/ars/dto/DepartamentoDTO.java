package com.api.ars.dto;

public class DepartamentoDTO {

	private String email;
	private String telefoneFixo;
	private Double orcamento;

	private String nomeSetor;

	private String cep;
	private String numero;
	private String complemento;

	public DepartamentoDTO() {
	}
	
	public DepartamentoDTO(String email, String telefoneFixo, Double orcamento, String nomeSetor, String cep,
			String numero, String complemento) {
		super();
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.orcamento = orcamento;
		this.nomeSetor = nomeSetor;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public String getNomeSetor() {
		return nomeSetor;
	}

	public void setNomeSetor(String nomeSetor) {
		this.nomeSetor = nomeSetor;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

}
