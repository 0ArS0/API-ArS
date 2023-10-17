package com.api.ars.dto;


public class FuncionarioDTO {

	private String nomeFuncionario;
	private String email;
	private String password;

	private String cep;
	private String numero;
	
	public FuncionarioDTO(String nomeFuncionario, String email, String password, String cep, String numero) {
		this.nomeFuncionario = nomeFuncionario;
		this.email = email;
		this.password = password;
		this.cep = cep;
		this.numero = numero;
	}
	
	public String getNomeUsuario() {
		return nomeFuncionario;
	}
	
	public void setNomeUsuario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
