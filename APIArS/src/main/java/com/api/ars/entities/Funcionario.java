package com.api.ars.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_func")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_func")
	private Integer id;
	
	@NotNull
	@Column(name = "nome_func")
	private String nome;
	
	@NotNull
	@Column(name = "cpf_func")
	private String cpf;
	
	@NotNull
	@Column(name = "senha_func")
	private String senha;

	@NotNull
	@Column(name = "endereco_func")
	private String endereco;

	@NotNull
	@Column(name = "email_func")
	private String email;

	@NotNull
	@Column(name = "telefone_fixo_func")
	private String telefoneFixo;

	@NotNull
	@Column(name = "celular_func")
	private String celular;

	@NotNull
	@Column(name = "genero_func")
	private String genero;

	@NotNull
	@Column(name = "cargo_func")
	private String cargo;

	@NotNull
	@Column(name = "salario_func")
	private Double salario;

	@NotNull
	@Column(name = "data_contratacao_func")
	private LocalDate dataContratacao;

	@NotNull
	@Column(name = "data_nascimento_func")
	private LocalDate dataNascimento;

	@NotNull
	@Column(name = "ativo_func")
	private Boolean ativo;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Departamento departamento;
	
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

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Funcionario() {
	}

	public Funcionario(Integer id, @NotNull String nome, @NotNull String cpf, @NotNull String senha,
			@NotNull String endereco, @NotNull String email, @NotNull String telefoneFixo, @NotNull String celular,
			@NotNull String genero, @NotNull String cargo, @NotNull Double salario, @NotNull LocalDate dataContratacao,
			@NotNull LocalDate dataNascimento, @NotNull Boolean ativo, Departamento departamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.endereco = endereco;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.genero = genero;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", endereco="
				+ endereco + ", email=" + email + ", telefoneFixo=" + telefoneFixo + ", celular=" + celular
				+ ", genero=" + genero + ", cargo=" + cargo + ", salario=" + salario + ", dataContratacao="
				+ dataContratacao + ", dataNascimento=" + dataNascimento + ", ativo=" + ativo + ", departamento="
				+ departamento + "]";
	}
	
}
