package com.api.ars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ars.entities.Departamento;
import com.api.ars.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {
	
	@Autowired
	DepartamentoRepository departamentoRepository;

	//GET Id
	public Departamento buscarPorId(Integer id) {
		return departamentoRepository.findById(id).get();
	}

	//GET Listar
	public List<Departamento> listarTodos() {
		return departamentoRepository.findAll();
	}
	
	//POST
	public Departamento salvar(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	//PUT
	public Departamento atualizar(Integer id, Departamento departamento) {
		Departamento registroAntigo = buscarPorId(id);

		if (departamento.getNome() != null) {
			registroAntigo.setNome(departamento.getNome());
		}
		if (departamento.getEndereco() != null) {
			registroAntigo.setEndereco(departamento.getEndereco());
		}
		if (departamento.getEmail() != null) {
			registroAntigo.setEmail(departamento.getEmail());
		}
		if (departamento.getTelefoneFixo() != null) {
			registroAntigo.setTelefoneFixo(departamento.getTelefoneFixo());
		}
		if (departamento.getOrcamento() != null) {
			registroAntigo.setOrcamento(departamento.getOrcamento());
		}
		if (departamento.getSetor() != null) {
			registroAntigo.setSetor(departamento.getSetor());
		}
		
		registroAntigo.setId(id);
		return departamentoRepository.save(registroAntigo);
	}
	
	//DELETE
	public void removerLogico(Integer id) {
		Departamento departamento = buscarPorId(id);

		if (departamento != null) {
			departamento.setAtivo(false);
			departamentoRepository.save(departamento);
		}
	}
}
