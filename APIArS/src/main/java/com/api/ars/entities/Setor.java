package com.api.ars.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_setor")
public class Setor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_setor")
	private Integer id;

	@NotNull(message = "O campo nome nao pode ser nulo")
	@Column(name = "nome_setor")
	private String nome;

	@NotNull(message = "O campo descricao nao pode ser nulo")
	@Column(name = "descricao_setor")
	private String descricao;

	public Setor() {
	}

	public Setor(Integer id, @NotNull(message = "O campo nome nao pode ser nulo") String nome,
			@NotNull(message = "O campo descricao nao pode ser nulo") String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}

}
