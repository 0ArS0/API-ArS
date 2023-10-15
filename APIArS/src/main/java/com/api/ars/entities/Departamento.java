package com.api.ars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dept")
public class Departamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dept")
	private Integer id;
	
	@Column(name = "nome_dept")
	private String nome;
	
	@Column(name = "endereco_dept")
	private String endereco;
	
	@Column(name = "email_dept")
	private String email;
	
	@Column(name = "telefone_fixo_dept")
	private String telefoneFixo;
	
	@Column(name = "celular_dept")
	private String celular;
	
	@Column(name = "descricao_dept")
	private String descricao;
	
	@Column(name = "data_criacao_dept")
	private LocalDate dataCriacao;
	
	@Column(name = "orcamento_dept")
	private Double orcamento;
	
	@Column(name = "ativo_dept")
	private Boolean ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Departamento() {
	}

	public Departamento(Integer id, String nome, String endereco, String email, String telefoneFixo, String celular,
			String descricao, LocalDate dataCriacao, Double orcamento, Boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.descricao = descricao;
		this.dataCriacao = dataCriacao;
		this.orcamento = orcamento;
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email
				+ ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + ", descricao=" + descricao
				+ ", dataCriacao=" + dataCriacao + ", orcamento=" + orcamento + ", ativo=" + ativo + "]";
	}

}