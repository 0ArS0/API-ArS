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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tb_departamento")
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private Integer id;

	@Email
	@NotNull(message = "Campo e-mail não pode ser nulo")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	@Column(name = "email_departamento")
	private String email;

	@Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}")
	@Column(name = "telefone_departamento")
	private String telefoneFixo;

	@NotNull(message = "Campo orcamento não pode ser nulo")
	@Column(name = "orcamento_departamento")
	private Double orcamento;

	@Column(name = "ativo_departamento")
	private Boolean ativo = true;

	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "setor_id")
	private Setor setor;

	public Departamento() {
	}

	public Departamento(Integer id, @NotNull String email, @NotNull String telefoneFixo, @NotNull Double orcamento,
			@NotNull Boolean ativo, Endereco endereco, Setor setor) {
		super();
		this.id = id;
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
		return "Departamento [id=" + id + ", email=" + email + ", telefoneFixo=" + telefoneFixo + ", orcamento="
				+ orcamento + ", ativo=" + ativo + ", endereco=" + endereco + ", setor=" + setor + "]";
	}

}