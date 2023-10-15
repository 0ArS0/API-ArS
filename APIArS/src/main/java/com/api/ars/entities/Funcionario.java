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

@Entity
@Table(name = "tb_func")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_func")
	private Integer id;
	
	@Column(name = "nome_func")
	private String nome;
	
	@Column(name = "endereco_func")
	private String endereco;
	
	@Column(name = "email_func")
	private String email;
	
	@Column(name = "telefone_fixo_func")
	private String telefoneFixo;
	
	@Column(name = "celular_func")
	private String celular;
	
	@Column(name = "genero_func")
	private String genero;
	
	@Column(name = "cargo_func")
	private String cargo;
	
	@Column(name = "salario_func")
	private Double salario;
	
	@Column(name = "data_contratacao_func")
	private LocalDate dataContratacao;
	
	@Column(name = "data_nascimento_func")
	private LocalDate dataNascimento;
	
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

	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String genero, String cargo, String endereco, String telefoneFixo,
			String celular, String email, Double salario, LocalDate dataContratacao, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.cargo = cargo;
		this.endereco = endereco;
		this.telefoneFixo = telefoneFixo;
		this.celular = celular;
		this.email = email;
		this.salario = salario;
		this.dataContratacao = dataContratacao;
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", genero=" + genero + ", Cargo=" + cargo + ", endereco="
				+ endereco + ", telefoneFixo=" + telefoneFixo + ", celular=" + celular + ", email=" + email
				+ ", salario=" + salario + ", dataContratacao=" + dataContratacao + ", dataNascimento=" + dataNascimento
				+ "]";
	}
	
}
