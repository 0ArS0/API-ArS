package com.api.ars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_dept")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dept")
	private Integer id;

	@NotNull
	@Column(name = "nome_dept")
	private String nome;

	@NotNull
	@Column(name = "descricao_dept")
	private String descricao;

	@NotNull
	@Column(name = "email_dept")
	private String email;

	@NotNull
	@Column(name = "telefone_fixo_dept")
	private String telefoneFixo;

	@NotNull
	@Column(name = "celular_dept")
	private String celular;

	@NotNull
	@Column(name = "data_criacao_dept")
	private LocalDate dataCriacao;

	@NotNull
	@Column(name = "orcamento_dept")
	private Double orcamento;

	@NotNull
	@Column(name = "ativo_dept")
	private Boolean ativo;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public Departamento(Integer id, @NotNull String nome, @NotNull String descricao, @NotNull String email,
			@NotNull String telefoneFixo, @NotNull String celular, @NotNull LocalDate dataCriacao,
			@NotNull Double orcamento, @NotNull Boolean ativo, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.dataCriacao = dataCriacao;
		this.orcamento = orcamento;
		this.ativo = ativo;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", email=" + email
				+ ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + ", dataCriacao=" + dataCriacao
				+ ", orcamento=" + orcamento + ", ativo=" + ativo + ", endereco=" + endereco + "]";
	}

}