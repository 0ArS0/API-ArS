package com.api.ars.entities;

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
@Table(name = "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Integer id;

	@NotNull
	@Column(name = "nome_departamento")
	private String nome;

	@NotNull
	@Column(name = "email_departamento")
	private String email;

	@NotNull
	@Column(name = "telefone_departamento")
	private String telefoneFixo;

	@NotNull
	@Column(name = "orcamento_departamento")
	private Double orcamento;

	@NotNull
	@Column(name = "ativo_departamento")
	private Boolean ativo;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	public Departamento() {
	}

	public Departamento(Integer id, @NotNull String nome, @NotNull String email, @NotNull String telefoneFixo,
			@NotNull Double orcamento, @NotNull Boolean ativo, Endereco endereco, Setor setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.orcamento = orcamento;
		this.ativo = ativo;
		this.endereco = endereco;
		this.setor = setor;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

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

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", email=" + email + ", telefoneFixo=" + telefoneFixo
				+ ", orcamento=" + orcamento + ", ativo=" + ativo + ", endereco=" + endereco + ", setor=" + setor + "]";
	}

}