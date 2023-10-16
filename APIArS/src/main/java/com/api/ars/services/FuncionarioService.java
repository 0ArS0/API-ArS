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

		if (funcionario.getNome() != null) {
			registroAntigo.setNome(funcionario.getNome());
		}
		if (funcionario.getEndereco() != null) {
			registroAntigo.setEndereco(funcionario.getEndereco());
		}
		if (funcionario.getEmail() != null) {
			registroAntigo.setEmail(funcionario.getEmail());
		}
		if (funcionario.getTelefoneFixo() != null) {
			registroAntigo.setTelefoneFixo(funcionario.getTelefoneFixo());
		}
		if (funcionario.getCelular() != null) {
			registroAntigo.setCelular(funcionario.getCelular());
		}
		if (funcionario.getSenha() != null) {
			registroAntigo.setSenha(funcionario.getSenha());
		}
		if (funcionario.getCargo() != null) {
			registroAntigo.setCargo(funcionario.getCargo());
		}
		if (funcionario.getSalario() != null) {
			registroAntigo.setSalario(funcionario.getSalario());
		}
		if (funcionario.getDepartamento() != null) {
			registroAntigo.setDepartamento(funcionario.getDepartamento());
		}
		
		registroAntigo.setId(id);
		return funcionarioRepository.save(registroAntigo);
	}
	
	//DELETE
	public void removerLogico(Integer id) {
		Funcionario funcionario = buscarPorId(id);

		if (funcionario != null) {
			funcionario.setAtivo(false);
			funcionarioRepository.save(funcionario);
		}
	}
}
