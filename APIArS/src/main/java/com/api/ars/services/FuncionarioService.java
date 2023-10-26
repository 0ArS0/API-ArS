package com.api.ars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ars.entities.Funcionario;
import com.api.ars.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	//GET Id
	public Funcionario buscarPorId(Integer id) {
		return funcionarioRepository.findById(id).get();
	}

	//GET Listar
	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}
	
	//POST
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	//PUT
	public Funcionario atualizar(Integer id, Funcionario funcionario) {
		Funcionario registroAntigo = buscarPorId(id);

		
		registroAntigo.setId(id);
		return funcionarioRepository.save(registroAntigo);
	}
	
	//DELETE
	public void removerLogico(Integer id) {
	}
}
