package com.api.ars.entities;

import java.time.LocalDate;

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
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private Integer id;

	@NotNull(message = "Campo salario não pode ser nulo")
	@Column(name = "salario")
	private Double salario;

	@NotNull
	@Column(name = "data_contratacao")
	private LocalDate dataContratacao;

	@NotNull(message = "Campo nome de usuario não pode ser nulo")
	@Column(name = "nome_usuario")
	private String nomeUsuario;

	@Column
	private Boolean ativo = true;

	@ManyToOne
	@JoinColumn(name = "departamento_id")
	private Departamento departamento;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Funcionario() {
	}

	public Funcionario(Integer id, @NotNull(message = "Campo salario não pode ser nulo") Double salario,
			@NotNull LocalDate dataContratacao,
			@NotNull(message = "Campo nome de usuario não pode ser nulo") String nomeUsuario, Boolean ativo,
			Departamento departamento, User user) {
		super();
		this.id = id;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.nomeUsuario = nomeUsuario;
		this.ativo = ativo;
		this.departamento = departamento;
		this.user = user;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", salario=" + salario + ", dataContratacao=" + dataContratacao
				+ ", nomeUsuario=" + nomeUsuario + ", ativo=" + ativo + ", departamento=" + departamento + ", user="
				+ user + "]";
	}

}
